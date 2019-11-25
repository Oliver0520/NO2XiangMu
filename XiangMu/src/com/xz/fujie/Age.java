package com.xz.fujie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Age {
   public Integer yearsold(String birthday) throws ParseException {
	  
	   //系统当前时间
	   SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		
		String now = df.format(new Date());
		
		Date d1 = new SimpleDateFormat("yyyy/MM/dd").parse(now);//定义起始日期
		
		SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy");

		SimpleDateFormat sdf1 = new SimpleDateFormat("MM");

		SimpleDateFormat sdf2= new SimpleDateFormat("dd");

		Integer str1 = Integer.parseInt(sdf0.format(d1));
		
		Integer str2 =  Integer.parseInt(sdf1.format(d1));

		Integer str3 =  Integer.parseInt(sdf2.format(d1));
		
		  LocalDate date1 = LocalDate.of(str1, str2, str3);
		  
			

	
//			传过来的出生日期
			Date abc = new SimpleDateFormat("yyyy-MM-dd").parse(birthday); 
			
			String bir = df.format(abc);
			
			Date d1b = new SimpleDateFormat("yyyy/MM/dd").parse(bir);
			
			SimpleDateFormat sdf0b = new SimpleDateFormat("yyyy");

			SimpleDateFormat sdf1b = new SimpleDateFormat("MM");

			SimpleDateFormat sdf2b = new SimpleDateFormat("dd");

			Integer str1b = Integer.parseInt(sdf0b.format(d1b));
			
			Integer str2b =  Integer.parseInt(sdf1b.format(d1b));

			Integer str3b =  Integer.parseInt(sdf2b.format(d1b));
		  
		  LocalDate date2 = LocalDate.of(str1b, str2b,str3b); 
		  Integer age = date2.until(date1).getYears();
		  
	   return age;
   }
}
