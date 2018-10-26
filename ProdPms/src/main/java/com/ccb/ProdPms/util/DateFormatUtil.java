package com.ccb.ProdPms.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormatUtil {
	public static void main(String[] args) throws Exception {
		Date date = new Date();
		System.out.println(date);
		// Thu Oct 18 16:09:28 CST 2018
		SimpleDateFormat sdf12 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat sdf24 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String format12 = sdf12.format(date);
		String format24 = sdf24.format(date);
		System.out.println(format12);
		System.out.println(format24);
		// 2018-10-18 04:09:28
		// 2018-10-18 16:09:28
		Date a12 = sdf12.parse(format12);
		Date a24 = sdf24.parse(format24);
		System.out.println(a12+","+a24);
		// Thu Oct 18 04:09:28 CST 2018,Thu Oct 18 16:09:28 CST 2018
		
		
		//标准时间转换
		LocalDate now=LocalDate.now();
		System.out.println(now);
	    DateTimeFormatter dfm=DateTimeFormatter.ofPattern("yyyyMMdd");
	    System.out.println(dfm);
	    String dateDir =now.format(dfm);
	    System.out.println(dateDir);
	}
}
