package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Q_13SelectRecordUsingWhereCondition {

	private static final String url="jdbc:mysql://localhost:3306/jfs44";
	private static final String username="root";
	private static final String password="Dev@2024";
	
	public static void main(String[] args) {
		String SQLQuery = "SELECT * FROM TEACHER where tno=?";
		try(Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement ps = con.prepareStatement(SQLQuery)){
			ps.setInt(1, 15);
			ResultSet rs = ps.executeQuery();
			System.out.println("TNO/ TNAME/ TSAL/ TADDR");
			System.out.println("----------------------------");
			if(rs.next()) {
				int tno=rs.getInt(1);
				String tname = rs.getString(2);
				double tsal = rs.getDouble(3);
				String taddr =rs.getString(4);
				System.out.println(tno+"\t"+tname+"\t"+tsal+"\t"+taddr);
			} else {
				System.out.println("No record found for teacher no");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
