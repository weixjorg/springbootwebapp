package com.root.maintest;

import com.root.utils.FtpJSch;

public class FtpJSchMain {
 
	
	
	public static void main(String[] args) {
		FtpJSch.getConnect();
	   FtpJSch.upload("d:/logs/log.txt");
	   /*
		Map<String,String> param =new HashMap<String,String>();
		param.put("flowNo", "123"); 
		System.out.println("1:"+param.get("flowNo"));
		param.put("flowNo", "456");
		System.out.println("2:"+param.get("flowNo"));
		param.put("flowNo", "456000");
		System.out.println("3:"+param.get("flowNo"));
		*/
    }
	
}
