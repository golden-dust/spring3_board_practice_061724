package com.goldendust.jdbc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.goldendust.jdbc.dao.MemberDao;
import com.goldendust.jdbc.dto.MemberDto;

public class MSearchCommand implements MCommand {
	
	@Override
	public int execute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MemberDao dao = new MemberDao();
		MemberDto member = dao.findById(request.getParameter("mid"));
		
		model.addAttribute("memberDto", member);
		
		return 1;
	}

}
