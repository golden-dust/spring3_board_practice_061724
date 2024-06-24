package com.goldendust.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.goldendust.jdbc.dto.MemberDto;

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
	
	// 3. 회원리스트조회
	public List<MemberDto> findAll() {
		
		List<MemberDto> membersList = new ArrayList<MemberDto>();
		
		String sql = "SELECT * FROM members";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();	// rs에 여러개의 레코드가 들어있음
			
			while (rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mdate = rs.getString("mdate");
				
				membersList.add(new MemberDto(mid, mpw, mname, memail, mdate));
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		
		return membersList;
	}
	
	// 4. 회원검색
	public MemberDto findByBlank(String item, String sql) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDto memberToFind = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, item);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mdate = rs.getString("mdate");
				
				memberToFind = new MemberDto(mid, mpw, mname, memail, mdate);
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		
		return memberToFind;
	}
	
	public MemberDto findById(String id) {
		
		String sql = "SELECT * FROM members WHERE mid = ?";
		
		MemberDto member = findByBlank(id, sql);
		return member;
	}
	
	public MemberDto findByEmail(String email) {
		
		String sql = "SELECT * FROM members WHERE memail= ?";
		
		MemberDto member = findByBlank(email, sql);
		return member;
	}
	
	// 5. 회원정보수정
	public int updateMember(String mid, String mname, String memail) {
		
		String sql = "UPDATE members SET mname=?, memail=? WHERE mid=?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		int result = 0;
		MemberDto member = findById(mid);
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mname);
			ps.setString(2, memail);
			ps.setString(3, mid);
			
			result = ps.executeUpdate();
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
		return result;
	}
}
