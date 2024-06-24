package com.goldendust.jdbc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.goldendust.jdbc.dao.MemberDao;
import com.goldendust.jdbc.dto.MemberDto;

public class MDeleteCommand implements MCommand {
	
	@Override
	public int execute(Model model) {
			
			// 일반적 방법으로 빼 올 수 없고, Map으로 빼 줘야 함
			Map<String, Object> map = model.asMap();
			HttpServletRequest request = (HttpServletRequest) map.get("request");
			
			int result = 0;
			
			String mid = request.getParameter("mid");
//			String mpw = request.getParameter("mpw");
						
			MemberDao memberDao = new MemberDao();
			
			MemberDto memberToDelete = memberDao.findById(mid);
//			if ((memberToDelete != null) && (mpw.equals(memberToDelete.getMpw()))) {
			if (memberToDelete != null) {
				result = memberDao.deleteMember(mid);
			}
			
			return result;
	}
}
