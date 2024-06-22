package com.goldendust.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goldendust.jdbc.command.MCommand;
import com.goldendust.jdbc.command.MDeleteCommand;
import com.goldendust.jdbc.command.MJoinCommand;
import com.goldendust.jdbc.command.MListCommand;
import com.goldendust.jdbc.command.MSearchCommand;
import com.goldendust.jdbc.command.MUpdateCommand;
import com.goldendust.jdbc.dao.MemberDao;
import com.goldendust.jdbc.dto.MemberDto;

@Controller
public class JdbcController {
	
	MCommand command = null;
	
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
	
	@RequestMapping(value="/joinOk", method=RequestMethod.POST)
	public String joinOk(HttpServletRequest request, Model model) {
		
		// 모델에 리퀘스트 객체 싣기
		model.addAttribute("request", request);
		
		command = new MJoinCommand();
		int result = command.execute(model);
		
//		try {
//			request.setCharacterEncoding("utf-8");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
//		String mid = request.getParameter("mid");
//		String mpw = request.getParameter("mpw");
//		String mname = request.getParameter("mname");
//		String memail = request.getParameter("memail");
		
//		MemberDao memberDao = new MemberDao();
		
//		int result = memberDao.joinMember(mid, mpw, mname, memail);
		
		if (result == 1) {
			model.addAttribute("mid", request.getParameter("mid"));
			model.addAttribute("mname", request.getParameter("mname"));
			return "joinOk";
		} else {
			model.addAttribute("error", "회원 가입이 실패하였습니다. 다시 시도해주세요.");
			return "join";
		}
	}
	
	@RequestMapping(value="/delete_account")
	public String goToWithdraw() {
		return "deleteAccount";
	}
	
	@RequestMapping(value="/account_deleted", method=RequestMethod.POST)
	public String deleteAccount(HttpServletRequest request , Model model) {

		model.addAttribute("request", request);
		
		command = new MDeleteCommand();
		
		int result = command.execute(model);
		
		if (result == 1) {
			return "deleteAccountOk";
		} else {
			model.addAttribute("error", "탈퇴 실패 : 아이디나 비밀번호를 다시 확인해주세요.");
			return "deleteAccount";
		}
	}
	
	@RequestMapping(value="/signin")
	public String goToSignin() {
		return "signin";
	}
	
	@RequestMapping(value="/idsearch")
	public String goToIdSearch() {
		return "idSearch";
	}
	
	@RequestMapping(value="/idsearch_result")
	public String searchId(HttpServletRequest request, Model model) {
		
		MemberDao memDao = new MemberDao();
		String email = request.getParameter("searchEmail");
		Optional<MemberDto> memberToFindOptional = Optional.ofNullable(memDao.findByEmail(email));
		
		if(memberToFindOptional.isPresent()) {
			MemberDto memberFound = memberToFindOptional.get();
			model.addAttribute("mid", memberFound.getMid());
			return "idSearchSuccess";
		} else {
			return "idSearchFailed";
		}
	}

	@RequestMapping(value="/updateInfoOk")
	public String updateInfo(HttpServletRequest request, Model model) {
		
		return "updateMemberInfo";
	}
	
	@RequestMapping(value="/pwsearch")
	public String goToPwSearch() {
		return "pwSearch";
	}
	
	@RequestMapping(value="/pwsearch_result")
	public String searchPw(HttpServletRequest request, Model model) {
		
		MemberDao memDao = new MemberDao();
		String id = request.getParameter("searchId");
		String email = request.getParameter("searchEmail");
		Optional<MemberDto> memberToFindOptional = Optional.ofNullable(memDao.findById(id));
		
		if(memberToFindOptional.isPresent()) {
			MemberDto memberFound = memberToFindOptional.get();
			if(email.equals(memberFound.getMemail())) {
				model.addAttribute("mpw", memberFound.getMpw());
				return "pwSearchSuccess";
			} else {
				model.addAttribute("error", "이메일이 일치하지 않습니다.");
				return "pwSearchFailed";
			}
		} else {
			model.addAttribute("error", "비밀번호 확인 실패: 아이디를 확인해주세요.");
			return "pwSearchFailed";
		}
	}
	
	@RequestMapping(value="/memberSearch")
	public String memberSearch() {
		return "memberSearch";
	}
	
	@RequestMapping(value="/memberSearchResult")
	public String memberSearchOk(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
	
		command = new MSearchCommand();
		command.execute(model);
		
		return "memberSearchOk";

	}
	
	@RequestMapping(value="/memberInfoUpdated", method=RequestMethod.POST)
	public String updateMember(HttpServletRequest request, Model model) {
		
		int result;
		
		model.addAttribute("request", request);
		command = new MUpdateCommand();
		result = command.execute(model);
		
		if (result == 1) {
			command = new MSearchCommand();
			command.execute(model);
			return "memberUpdateOk";
		} 
		return "memberSearch";
	}
	
	@RequestMapping(value="/memberlist")
	public String list(Model model) {
		
		command = new MListCommand();
		command.execute(model);
		
		return "memberList";
	}
//	
//	@RequestMapping(value="/index")	// value="/" 첫페이지 인덱스
//	public String index() {
//		return "index";
//	}

}
