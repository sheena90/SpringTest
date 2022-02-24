package com.sheena.SpringTest.lesson05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSTL01Controller {

	@GetMapping("/lesson05/test01")
	public String test01() {
		return "lesson05/test01";
	}
}
