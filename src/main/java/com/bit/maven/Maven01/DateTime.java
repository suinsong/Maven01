package com.bit.maven.Maven01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTime {

	public static void main(String[] args) {
		
		Date getDate = new Date();  // 현재 시각 추출
		System.out.println(getDate.toString());
		
		// 날짜 포맷
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd ");
		String todayDate = dateFormat.format(getDate);
	
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		String curTime = timeFormat.format(getDate);
		
		SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss" );
		String dt = dateTime.format(getDate);
		
		System.out.println(todayDate);
		System.out.println(curTime);
		System.out.println(dt);
		
		System.out.println(getDate.getTime());
		
		
		
		Calendar cal = Calendar.getInstance(); //static이 붙여져 있는 클래스임
		todayDate = dateFormat.format(cal.getTime());
		curTime = timeFormat.format(cal.getTime());
		dt= dateTime.format(cal.getTime());
		
		
		System.out.println(todayDate);
		System.out.println(curTime);
		System.out.println(dt);
		
		
	}

}
