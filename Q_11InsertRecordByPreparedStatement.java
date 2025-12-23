package com.codegnan.jdbcprograms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Q_11InsertRecordByPreparedStatement {
	private static final String url="jdbc:mysql://localhost:3306/jfs44";
	private static final String username="root";
	private static final String password="Dev@2024";

	public static void main(String[] args) {
//		String insertQuery = "INSERT INTO TEACHER(TNAME, TSAL,TADDR) VALUES(?,?,?)";
//		String SQlQuery = "UPDATE TEACHER SET TNAME=?, TSAL=?, TADDR=? WHERE TNO=?";
		String SQlQuery = "DELETE FROM TEACHER WHERE TNO=?";
		try(Connection con = DriverManager.getConnection(url, username, password);
				Scanner sc = new Scanner(System.in);
				PreparedStatement ps = con.prepareStatement(SQlQuery)){
				System.out.println("Enter Teacher No: ");
				int no = sc.nextInt();
//			    System.out.println("Enter Teacher Name: ");
//	            String name = sc.next();
//	            System.out.println("Enter Teacher Salary: ");
//	            Double salary = sc.nextDouble();
//	            System.out.println("Enter Teacher Address: ");
//	            String address = sc.next();
//	            
//			ps.setString(1, name);
//			ps.setDouble(2, salary);
//			ps.setString(3, address);
			ps.setInt(1, no);
			int rowsAffected = ps.executeUpdate();
			
			if(rowsAffected == 1) {
				System.out.println("Rows Inserted Successfully");
			} else {
				System.out.println("Record Not Inserted");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
