package com.goldendust.jdbc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.goldendust.jdbc.dao.MemberDao;

public class MUpdateCommand implements MCommand {

	@Override
	public int execute(Model model) {
		int result = 0;
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		MemberDao dao = new MemberDao();
		result = dao.updateMember(mid, mname, memail);

		return result;
	}

}
