package com.root;

import java.util.Calendar;

public class MainTest {
    
	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2001);
		cal.set(Calendar.MONTH, Calendar.MAY);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.add(Calendar.MONTH, -3);//当前时间的三个月前
		//输出结果
		System.out.println("YEAR: "+cal.get(Calendar.YEAR));
		int actualMonth = cal.get(Calendar.MONTH)+1;//月份是从0开始的
		System.out.println("MONTH: "+actualMonth);
		System.out.println("DAY_OF_MONTH: "+cal.get(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.YEAR, 2000);
		cal.set(Calendar.MONTH, Calendar.MAY);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		cal.add(Calendar.MONTH, -3);//当前时间的三个月前
		//输出结果
		System.out.println("YEAR: "+cal.get(Calendar.YEAR));
		actualMonth = cal.get(Calendar.MONTH)+1;//月份是从0开始的
		System.out.println("MONTH: "+actualMonth);
		System.out.println("DAY_OF_MONTH: "+cal.get(Calendar.DAY_OF_MONTH));
	}
}
