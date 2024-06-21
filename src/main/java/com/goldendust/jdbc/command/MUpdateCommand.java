package com.goldendust.jdbc.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.goldendust.jdbc.dao.MemberDao;

public class MUpdateCommand implements MCommand {

	@Override
	public int execute(Model model) {
		int result = 0;
		Map<String, Object> map = model.asMap();
		String mid = (String) map.get("mid");
		String mname = (String) map.get("mname");
		String memail = (String) map.get("memail");
		String mpw = (String) map.get("mpw");
		
		MemberDao dao = new MemberDao();
		result = dao.updateMember(mid, mname, memail, mpw);

		return result;
	}

}
