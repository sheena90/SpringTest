package com.sheena.SpringTest.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheena.SpringTest.lesson04.bo.SellerBO;
import com.sheena.SpringTest.lesson04.model.SellerModel;

@RequestMapping("/lesson04/test01")
@Controller
public class SellerController {
	
	// 1. seller 추가
	
	// input
	@GetMapping("/input")
	public String sellerInput() {
		return "lesson04/test01/test01_input";
	}
	
	@Autowired
	private SellerBO sellerBO;
	
	// INSERT(닉네임, 프로필 사진 url, 온도
	@ResponseBody
	@GetMapping("/add_seller")
	public String addSeller(
		@RequestParam("name") String nickname,
		@RequestParam("profileUrl") String profileImageUrl,
		@RequestParam("temperature") double temperature) {
		
		int count = sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "입력 성공 : " + count;
	}
		

	
	// 2. seller 출력		
	
	@GetMapping("/seller_info")
	public String getSellerView(Model model) {
		SellerModel seller = sellerBO.getLastSeller();
		
		model.addAttribute("result", seller); // "result" jsp에서 사용을 위한 변수명
		
		return "lesson04/test01/test01_sellerInfo";
	}
	
	
	
	// 3. seller 검색 출력

	public String getSellerView(
			@RequestParam(value="id", required=false) Integer id,
			Model model) {
		
		if(id != null) {
			
			SellerModel seller = sellerBO.getSeller(id);
			model.addAttribute("result", seller);  // if, else 중 하나만 실행되기 떄문에 변수명이 같아도 됨.
			
		} else {
			
			SellerModel seller = sellerBO.getLastSeller();		
			model.addAttribute("result", seller); // "result" jsp에서 사용을 위한 변수명
		}
		
		return "lesson04/test01/test01_sellerInfo";
	}
	
	
	
	

}
