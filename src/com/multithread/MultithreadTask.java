package com.multithread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.sql.DataSource;


public final class MultithreadTask extends Thread{

	private DataSource dataSource;
	private String sql;
	private List<Object[]> list;
	public static int num = 0 ;
	
	public MultithreadTask(DataSource dataSource, String sql,
			List<Object[]> list) {
		this.dataSource = dataSource;
		this.sql = sql;
		this.list = list;
	}

	@Override
	public void run() {
			//TODO something
	}
	public static void main(String[] args) {
		DataSource dataSource = null;
		List<List<Object[]>> list1 = null;
		String insertSql = "";
		ExecutorService exeService = Executors.newCachedThreadPool();
		for(List<Object[]> slist : list1){
			exeService.execute(new MultithreadTask(dataSource, insertSql, slist));
		}
	}
	
}
