package com.root;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestMain {
   
	
	
	public static void main(String[] args) {
		Date dNow = new Date(); //当前时间
		Date dBefore = new Date();
		Calendar calendar = Calendar.getInstance(); //得到日历
		calendar.setTime(dNow);//把当前时间赋给日历
		calendar.add(calendar.MONTH, -3); //设置为前3月
		calendar.add(calendar.DAY_OF_MONTH,-1);
		dBefore = calendar.getTime(); //得到前3月的时间
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
		String defaultStartDate = sdf.format(dBefore); //格式化前3月的时间
		String defaultEndDate = sdf.format(dNow); //格式化当前时间
		System.out.println("前3个月的时间是：" + defaultStartDate);
		System.out.println("生成的时间是：" + defaultEndDate);
	}
}
