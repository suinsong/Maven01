package com.bit.maven.Maven01;

import java.sql.*;

import com.bit.maven.Maven01.dbconfig.DbConfig;

public class Dbms01 {

	public static void main(String[] args) {

		try {
			Class.forName(DbConfig.DB_Driver);
			Connection conn = DriverManager.getConnection(
					DbConfig.DB_Url, 
					DbConfig.DB_User,
					DbConfig.DB_Passwd);
				
			String sql = " select * from buyer limit 10 ";

			PreparedStatement pSt = conn.prepareStatement(sql);
			ResultSet rs = pSt.executeQuery();

			while (rs.next()) {
				System.out.print(rs.getInt("id") + "\t");
				System.out.print(rs.getString("bucode") + "\t");
				System.out.print(rs.getString("buname") + "\t");
				System.out.print(rs.getString("butel") + "\t");
				System.out.print(rs.getString("buaddr") + "\t");
				System.out.println(rs.getString("bupoint") + "\t");

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
