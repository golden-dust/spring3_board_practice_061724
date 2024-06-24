package com.goldendust.jdbc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.goldendust.jdbc.dao.MemberDao;
import com.goldendust.jdbc.dto.MemberDto;

public class PwCheckCommand implements MCommand{
	
	private MemberDao dao;
	
	public PwCheckCommand() {
		this.dao = new MemberDao();
	}
	
	public String getPwFromDb(String mid) {
		
		MemberDto member = dao.findById(mid);
		String pw = member.getMpw();
		
		return pw;
	}
	
	@Override
	public int execute(Model model) {
		int success = 0;
		// Get request from map, then get mid and mpw from request
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		MemberDao mdao = new MemberDao();
		
		// Check if id is in DB
		if (mdao.isAvailable(mid) == 1) {
			String pw = getPwFromDb(mid);
			if (mpw.equals(pw)) {
				success = 1;
			}
		}
		return success;
	}

}
