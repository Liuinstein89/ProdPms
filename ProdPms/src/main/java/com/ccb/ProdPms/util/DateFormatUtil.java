package com.ccb.ProdPms.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {
	public static void main(String[] args) throws Exception {
		/*Date date = new Date();
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
		System.out.println(a12 + "," + a24);
		// Thu Oct 18 04:09:28 CST 2018,Thu Oct 18 16:09:28 CST 2018
		Date datee = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1000-10-10 22:22:22");
		Date dae = new java.sql.Timestamp(datee.getTime());
		System.out.println("22222222222" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("1000-10-10 22:22:22"));
		System.out.println("222" + dae);
		// Thu Oct 10 22:22:22 CST 1000
		Date dat = new java.sql.Date(datee.getTime());
		System.out.println(new java.sql.Date(datee.getTime()));*/
		// 1000-10-10
		// 标准时间转换
		/*LocalDate now = LocalDate.now();
		System.out.println(now);
		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("yyyyMMdd");
		System.out.println(dfm);
		String dateDir = now.format(dfm);
		System.out.println(dateDir);*/

		// 获取时间戳的三种方式
		// 精确到毫秒
		System.out.println(System.currentTimeMillis());
		System.out.println(Calendar.getInstance().getTimeInMillis());
		System.out.println(new Date().getTime());
		// 13位时间戳传给前端只需要/1000

		// 获取日期
		System.out.println(new Timestamp(System.currentTimeMillis()));// new Date()为获取当前系统时间
		// 结果:2018-10-17 22:33:16.521

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		System.out.println(df.format(new Date()));
		// 结果：2018-10-17 22:11:53

		// 时间戳转换成日期时间
		long timeStamp = System.currentTimeMillis();
		String sd = df.format(new Date(timeStamp));
		System.out.println(sd);// 打印出你要的时间
		// 结果：2018-10-17 22:39:31
	}
}
