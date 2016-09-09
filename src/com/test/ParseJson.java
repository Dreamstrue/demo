package com.test;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ParseJson {

	public static void parseD(){

		
		String result = "{\"proList\": " +
				"[{\"id\": \"402889e9530b798201530b8bd7e30007\",\"productName\": \"十三香饺子馅调味剂\"},"+
				"{\"id\": \"402889e9530b798201530b8da2b5000c\",\"productName\": \"十三香清真骨汤料\"}],"+
				"\"proxyList\": " +
				"[{\"id\": \"402889e9530be44501530bf5c9af0001\",\"cSubMemberId\": \"402889e9530be44501530bf5c9690000\",\"cPorductId\": \"4445454545454545454\"}],"+
				"\"STATUS\": \"SUCCESS\","+
				"\"subList\": ["+
				"{"+
            "\"id\": \"402889e9530be44501530bf5c9690000\","+
            "\"cAgencyName\": \"洛阳十三香经销商\"}]}";
		System.out.println(result);
		result="name:15";
        //json串
		JSONObject jsonObject = JSONObject.fromObject(result);
		JSONArray jsonarr = jsonObject.getJSONArray("proList");
        for(int i=0;i<jsonarr.size();i++){
            JSONObject proObject = jsonarr.getJSONObject(i);
            System.out.println(proObject);
        }
//			JSONArray proxyList = object.getJSONArray("proxyList");
//			for(int i=0;i<proxyList.length();i++){
//				JSONObject proxyObject = proxyList.getJSONObject(i);
//				proxyListInfo = new ProxyListInfo();
//				proxyListInfo.setId(proxyObject.getString("id"));
//				proxyListInfo.setcSubMemberId(proxyObject.getString("cSubMemberId"));
//				proxyListInfo.setcPorductId(proxyObject.getString("cPorductId"));
//				proxyListInfos.add(proxyListInfo);
//			}
//			JSONArray agencyLists = object.getJSONArray("subList");
//			for(int i=0;i<agencyLists.length();i++){
//				JSONObject agencyObject = agencyLists.getJSONObject(i);
//				agencyInfo = new AgencyInfo();
//				agencyInfo.setId(agencyObject.getString("id"));
//				agencyInfo.setAgencyName(agencyObject.getString("cAgencyName"));
//				agencyInfos.add(agencyInfo);
//			}
	}
	
	public static void main(String[] args) {
		parseD();
	}

}
