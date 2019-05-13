package com.xz.fujie;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test4 {
public static void main(String[] args) {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat miao = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println(df.format(new Date()));
	System.out.println(miao.format(new Date()));
	String a=df.format(new Date())+" 09:00:00";
	System.out.println(a);
}
}
