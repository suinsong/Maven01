package com.bit.maven.Maven01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.bit.maven.Maven01.dbconfig.DbConfig;

public class Sales {

	public static void main(String[] args) {
		try {
			Class.forName(DbConfig.DB_Driver);
			Connection conn = DriverManager.getConnection(
					DbConfig.DB_Url,
					DbConfig.DB_User,
					DbConfig.DB_Passwd
										);
			
			String sql = " select count(*) from buyer " ;
			PreparedStatement pSt =conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery();
			rs.next();
			
			int recCount = rs.getInt(1); //결과 값(513개) 이 한 줄이라 while로 안 묶음
			
			//1부터 레코드 개수 범위내의 임의의 id값을 생성
			int getId = (int)(Math.random()*recCount+1);
			
			// 임의로 생성된 id를 이용해서 buyer레코드 1개를 추출
			sql = " select * from buyer where id = ? ";
			pSt = conn.prepareStatement(sql);
			pSt.setInt(1,  getId);
			rs = pSt.executeQuery();
			
			rs.next();
			System.out.print(rs.getInt("id")+"\t");
			System.out.print(rs.getString("bucode")+"\t");		
			System.out.print(rs.getString("buname")+"\t");	
			System.out.print(rs.getString("butel")+"\t");	
			System.out.print(rs.getString("buaddr")+"\t");	
			
			System.out.println();
			
			String saleSQL = " insert into sales (sadate, satime, sabucode) " 
					+ "values(?,?,?) ; ";
			pSt = conn.prepareStatement(saleSQL);
			
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");
		
			pSt.setString(1, dateFormat.format(cal.getTime()));
			pSt.setString(2, timeFormat.format(cal.getTime()));
			pSt.setString(3, rs.getString("bucode"));
			pSt.executeUpdate();
			
			System.out.println("추가 성공");
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
