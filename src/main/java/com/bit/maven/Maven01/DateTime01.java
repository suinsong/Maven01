package com.bit.maven.Maven01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateTime01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("날짜(yyyy/MM/dd)");
			String date = scanner.nextLine();
			System.out.println(date);

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			try {
				Date getDate = dateFormat.parse(date);
				break;

			} catch (ParseException e) {
				System.out.println(" 입력한 날짜 형식이 잘못되었습니다 ");
			}

		}
		System.out.println("입력한 날짜 형식이 맞습니다");
	}

}
