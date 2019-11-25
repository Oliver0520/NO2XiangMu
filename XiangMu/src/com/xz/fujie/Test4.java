package com.xz.fujie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class Test4 {
public static void main(String[] args) throws ParseException {
//	获取系统当前时间
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); SimpleDateFormat
		 * miao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * System.out.println(df.format(new Date())); System.out.println(miao.format(new
		 * Date())); String a=df.format(new Date())+" 09:00:00"; System.out.println(a);
		 */
//	产生随机数
//	Random random = new Random();
//	String str = "ABCDEFGHIJKLMNOOPQRSTUVWXYZ";
//	str += str.toLowerCase();
//	str += "0123456789";
//	StringBuilder sb = new StringBuilder(6);
//	for(int i = 0;i<6;i++)
//	{
//		char ch = str.charAt(new Random().nextInt(str.length()));
//		sb.append(ch);
//	}
//	String suijishu = sb.toString();
//	System.out.println(suijishu);
	
//  从出生年月获取当前年龄
		
		
		/*
		 * String str0 = "2019-05-29 21:50:20";
		 * 
		 * 
		 * 
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		 * 
		 * String now = df.format(new Date());
		 * 
		 * // Date d1 = new SimpleDateFormat("yyyy/MM/dd").parse(now);//定义起始日期 Date abc
		 * = new SimpleDateFormat("yyyy-MM-dd").parse(str0); String bir =
		 * df.format(abc);
		 * 
		 * Date d1 = new SimpleDateFormat("yyyy/MM/dd").parse(bir);
		 * 
		 * SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy");
		 * 
		 * SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
		 * 
		 * SimpleDateFormat sdf2= new SimpleDateFormat("dd");
		 * 
		 * Integer str1 = Integer.parseInt(sdf0.format(d1));
		 * 
		 * Integer str2 = Integer.parseInt(sdf1.format(d1));
		 * 
		 * Integer str3 = Integer.parseInt(sdf2.format(d1));
		 * 
		 * System.out.println("年份为："+str1);
		 * 
		 * System.out.println("月份为："+str2);
		 * 
		 * System.out.println("日为："+str3);
		 * 
		 * LocalDate date1 = LocalDate.of(str1, str2, str3); LocalDate date2 =
		 * LocalDate.of(1991, 1, 3); int age = date2.until(date1).getYears();
		 * 
		 * System.out.println("You're " + age + " years old.");
		 */
	
	Age a=new Age();
	Integer yearsold = a.yearsold("2000-01-08");
	System.out.println(yearsold);
}
}
