package com.goldendust.jdbc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.goldendust.jdbc.dao.MemberDao;

public class MJoinCommand implements MCommand {
	
	@Override
	public int execute(Model model) {
		
		// 일반적 방법으로 빼 올 수 없고, Map으로 빼 줘야 함
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		MemberDao memberDao = new MemberDao();
		
		int result = memberDao.joinMember(mid, mpw, mname, memail);
		
		return result;
	}

}
