package com.xz.fujie;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Test4 {
public static void main(String[] args) {
//	获取系统当前时间
		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); SimpleDateFormat
		 * miao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * System.out.println(df.format(new Date())); System.out.println(miao.format(new
		 * Date())); String a=df.format(new Date())+" 09:00:00"; System.out.println(a);
		 */
//	产生随机数
//	Random random = new Random();
	String str = "ABCDEFGHIJKLMNOOPQRSTUVWXYZ";
	str += str.toLowerCase();
	str += "0123456789";
	StringBuilder sb = new StringBuilder(6);
	for(int i = 0;i<6;i++)
	{
		char ch = str.charAt(new Random().nextInt(str.length()));
		sb.append(ch);
	}
	String suijishu = sb.toString();
	System.out.println(suijishu);
}
}
