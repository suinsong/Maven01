package com.bit.maven.Maven01;

import java.sql.*;

import com.bit.maven.Maven01.dbconfig.DbConfig;

public class SalesView {

	public static void main(String[] args) {

		try {
			Class.forName(DbConfig.DB_Driver);
			Connection conn =DriverManager.getConnection(
					DbConfig.DB_Url,
					DbConfig.DB_User,
					DbConfig.DB_Passwd);
			
			String sql = " select sadate , satime, sabucode, buname from sales " +
						" left join buyer on sales.sabucode = buyer.bucode " ;

			PreparedStatement pSt = conn.prepareStatement(sql);
			ResultSet rs =pSt.executeQuery();
			
			while(rs.next()){
				System.out.print(rs.getString("sadate")+"\t");
				System.out.print(rs.getString("satime")+"\t");
				System.out.print(rs.getString("sabucode")+"\t");
				System.out.println(rs.getString("buname")+"\t");
				
			
			}
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(" - 성공 - ");
		
	}

}
