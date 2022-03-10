package com.sheena.SpringTest.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheena.SpringTest.lesson06.bo.FavoriteBO;
import com.sheena.SpringTest.lesson06.model.FavoriteModel;

@Controller
@RequestMapping("/lesson06")
public class favoriteController {
	
	@Autowired
	private FavoriteBO favoriteBO;

	@GetMapping("/input")
	public String input() {
		return "lesson06/favorite/input";
	}
	
	@GetMapping("/add_favorite")
	@ResponseBody
	public Map<String, String> addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url") String url) {
		
		int count = favoriteBO.addFavorite(name, url);
		
		// 성공시
		// {"result":"success"}
		
		// 실패시
		// {"result":"fail"}
		
		Map<String, String> resultMap = new HashMap<>();
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	@GetMapping("/list")
	public String favoriteList(Model model) {
		List<FavoriteModel> favoriteList = favoriteBO.getFavoriteList();
		
		model.addAttribute("favorite", favoriteList);
		
		return "lesson06/favorite/favorite";
	}
	
	
	// 중복 확인
	@GetMapping("/duplicate")
	@ResponseBody
	public Map<String, Boolean> duplicate(@RequestParam("url") String url) {
		boolean duplicate = favoriteBO.duplicate(url);
		
		Map<String, Boolean> resultMap = new HashMap<>();
		
		resultMap.put("duplicate", duplicate);
		return resultMap;
	}
	
	
	
	// 삭제
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> delete(@RequestParam("id") int id) {
		
		int count = favoriteBO.deleteFavorite(id);
		
		// {"result":"success"}
		// {"result":"fail"}
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		return result;
	}
	
}
