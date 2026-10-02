package com.sample;

import java.time.LocalDate;

public class AppUtility {

	//回應現在的民國年月日
	public static String chineseDate() {
		LocalDate localdate = LocalDate.now() ;
		
		int year = localdate.getYear()-1911 ;
		int month = localdate.getMonthValue() ;
		int day = localdate.getDayOfMonth() ;
		
		return String.format("民國 %d 年 %d 月 %d日" ,year,month,day) ;
		
	}
		
}
