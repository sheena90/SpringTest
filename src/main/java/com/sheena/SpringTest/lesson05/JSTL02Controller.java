package com.sheena.SpringTest.lesson05;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSTL02Controller {
	
	@GetMapping("/lesson05/test02")
	public String text02(Model model) {		

		List<String> musicRanking = new ArrayList<>();
		musicRanking.add("강남스타일");
		musicRanking.add("벚꽃엔딩");
		musicRanking.add("좋은날");
		musicRanking.add("거짓말");
		musicRanking.add("보고싶다");
		
		model.addAttribute("music", musicRanking);
		
		return "lesson05/test02";
		
	}
	

}
