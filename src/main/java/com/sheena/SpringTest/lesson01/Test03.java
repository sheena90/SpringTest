package com.sheena.SpringTest.lesson01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test03 {
	
	@RequestMapping("/lesson01/test03/1")
	public String view() {
		return "lesson01/test03/test03";
	}

}
