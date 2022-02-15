package com.sheena.SpringTest.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson01/test01")
public class Test01Controller {
	
	@RequestMapping("/1")
	@ResponseBody
	public String start() {
		return "<h2>테스트 프로젝트 완성</h2>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.";
	}

	// 3. Map JSON 출력
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Integer> printMap() {
		Map<String, Integer> score = new HashMap<>();
		
		score.put("국어", 80);
		score.put("수학", 90);
		score.put("영어", 85);
		
		return score;
	}
	
	
	
	
}
