package com.testSocket.after_jdk1_4_NioSocket.test;

import java.io.IOException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.IllegalSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.spi.AbstractSelectableChannel;
import java.nio.channels.spi.AbstractSelector;
import java.nio.channels.spi.SelectorProvider;
import java.net.SocketException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Base Selector implementation class.
 */

abstract class SelectorImpl extends AbstractSelector {

	// The set of keys with data ready for an operation
	protected Set<SelectionKey> selectedKeys;

	// The set of keys registered with this Selector
	protected HashSet<SelectionKey> keys;

	// Public views of the key sets
	private Set<SelectionKey> publicKeys; // Immutable
	private Set<SelectionKey> publicSelectedKeys; // Removal allowed, but not
													// addition

	protected SelectorImpl(SelectorProvider sp) {
		super(sp);
		keys = new HashSet<SelectionKey>();
		selectedKeys = new HashSet<SelectionKey>();
		if (Util.atBugLevel("1.4")) {
			publicKeys = keys;
			publicSelectedKeys = selectedKeys;
		} else {
			publicKeys = Collections.unmodifiableSet(keys);
			publicSelectedKeys = Util.ungrowableSet(selectedKeys);
		}
	}

	public Set<SelectionKey> keys() {
		if (!isOpen() && !Util.atBugLevel("1.4"))
			throw new ClosedSelectorException();
		return publicKeys;
	}

	public Set<SelectionKey> selectedKeys() {
		if (!isOpen() && !Util.atBugLevel("1.4"))
			throw new ClosedSelectorException();
		return publicSelectedKeys;
	}

	protected abstract int doSelect(long timeout) throws IOException;

	private int lockAndDoSelect(long timeout) throws IOException {
		synchronized (this) {
			if (!isOpen())
				throw new ClosedSelectorException();
			synchronized (publicKeys) {
				synchronized (publicSelectedKeys) {
					return doSelect(timeout);
				}
			}
		}
	}

	public int select(long timeout) throws IOException {
		if (timeout < 0)
			throw new IllegalArgumentException("Negative timeout");
		return lockAndDoSelect((timeout == 0) ? -1 : timeout);
	}

	public int select() throws IOException {
		return select(0);
	}

	public int selectNow() throws IOException {
		return lockAndDoSelect(0);
	}

	public void implCloseSelector() throws IOException {
		wakeup();
		synchronized (this) {
			synchronized (publicKeys) {
				synchronized (publicSelectedKeys) {
					implClose();
				}
			}
		}
	}

	protected abstract void implClose() throws IOException;

	void putEventOps(SelectionKeyImpl sk, int ops) {
	}

	protected final SelectionKey register(AbstractSelectableChannel ch,
			int ops, Object attachment) {
		if (!(ch instanceof SelChImpl))
			throw new IllegalSelectorException();
		SelectionKeyImpl k = new SelectionKeyImpl((SelChImpl) ch, this);
		k.attach(attachment);
		synchronized (publicKeys) {
			implRegister(k);
		}
		k.interestOps(ops);
		return k;
	}

	protected abstract void implRegister(SelectionKeyImpl ski);

	void processDeregisterQueue() throws IOException {
		// Precondition: Synchronized on this, keys, and selectedKeys
		Set cks = cancelledKeys();
		synchronized (cks) {
			if (!cks.isEmpty()) {
				Iterator i = cks.iterator();
				while (i.hasNext()) {
					SelectionKeyImpl ski = (SelectionKeyImpl) i.next();
					try {
						implDereg(ski);
					} catch (SocketException se) {
						IOException ioe = new IOException(
								"Error deregistering key");
						ioe.initCause(se);
						throw ioe;
					} finally {
						i.remove();
					}
				}
			}
		}
	}

	protected abstract void implDereg(SelectionKeyImpl ski) throws IOException;

	abstract public Selector wakeup();

}
