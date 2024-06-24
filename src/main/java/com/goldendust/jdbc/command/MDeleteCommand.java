package com.goldendust.jdbc.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.goldendust.jdbc.dao.MemberDao;
import com.goldendust.jdbc.dto.MemberDto;

public class MDeleteCommand implements MCommand {
	
	@Override
	public int execute(Model model) {
			
		int result = 0;
		
		// 일반적 방법으로 빼 올 수 없고, Map으로 빼 줘야 함
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		int pwchecked = 0;
		
		// 전달받은 패스워드 파라미터 null 값 확인
		if (mpw != null) {
			PwCheckCommand pwcommand = new PwCheckCommand();
			pwchecked = pwcommand.execute(model);
		}
		
		// 파라미터 확인 후 입력pw와 db pw 일치 여부 확인 
		if (pwchecked == 1) {		
			MemberDao memberDao = new MemberDao();
			result = memberDao.deleteMember(mid);
		}
		return result;
	}
}
