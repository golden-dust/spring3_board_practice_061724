package com.goldendust.jdbc.command;

import java.util.List;

import org.springframework.ui.Model;

import com.goldendust.jdbc.dao.MemberDao;
import com.goldendust.jdbc.dto.MemberDto;

public class MListCommand implements MCommand {

	@Override
	public int execute(Model model) {
		
		MemberDao dao = new MemberDao();
		List<MemberDto> memberList = dao.findAll();
		model.addAttribute("memberList", memberList);
		
		return 1;
	}

}
