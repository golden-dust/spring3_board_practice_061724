package com.goldendust.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.goldendust.jdbc.dao.MemberDao;
import com.goldendust.jdbc.dto.MemberDto;

@Controller
public class JdbcController {
	
	@RequestMapping(value="/test")
	public void test() {
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/springproject_db";
		String username = "root";
		String password = "12345";
		
		Connection conn = null;
		System.out.println("Connection created");
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
			System.out.println("DB connected");
		} catch (Exception e) {
			System.out.println("Error: DB not connected");
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//return "test";
	}
	
	@RequestMapping(value="/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value="/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		MemberDao memberDao = new MemberDao();
		int result = memberDao.joinMember(mid, mpw, mname, memail);
		
		if (result == 1) {
			model.addAttribute("mid", mid);
			model.addAttribute("mname", mname);
			return "joinOk";
		} else {
			model.addAttribute("error", "회원 가입이 실패하였습니다. 다시 시도해주세요.");
			return "join";
		}
	}
	
	@RequestMapping(value="/delete_account")
	public String goToWithdraw() {
		return "withdraw";
	}
	
	@RequestMapping(value="/account_deleted")
	public String deleteAccount(@RequestParam("mid") String mid, Model model) {
		MemberDao memberToDelete = new MemberDao();
		
		int result = memberToDelete.deleteMember(mid);
		
		if (result == 1) {
			return "withdrawOk";
		} else {
			model.addAttribute("error", "탈퇴에 실패하였습니다. 아이디를 다시 확인해주세요.");
			return "withdraw";
		}
		
	}

}
