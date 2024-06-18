package com.goldendust.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MemberDao {
	
	String driverName = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/springproject_db";
	String username = "root";
	String password = "12345";
	
	// 회원가입, 회원탈퇴, 회원리스트조회, 회원검색, 회원정보수정
	
	// 1. 회원가입 method
	public int joinMember(String mid, String mpw, String mname, String memail) {
		
		String sql = "INSERT INTO members(mid, mpw, mname, memail) VALUES(?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement ps = null;
		int success = 0;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mid);
			ps.setString(2, mpw);
			ps.setString(3, mname);
			ps.setString(4, memail);
			
			success = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (ps != null) {
					ps.close();
				}
				
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return success;
	}
	
	// 2. 회원 탈퇴
	public int deleteMember(String mid) {
		
		String sql = "DELETE FROM members WHERE mid = ?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		int success = 0;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mid);
			
			success = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return success;
	}

}
