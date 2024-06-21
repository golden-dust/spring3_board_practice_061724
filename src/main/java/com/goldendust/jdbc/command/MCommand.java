package com.goldendust.jdbc.command;

import org.springframework.ui.Model;

public interface MCommand {
	
	public int execute(Model model);	// 추상 메소드

}
