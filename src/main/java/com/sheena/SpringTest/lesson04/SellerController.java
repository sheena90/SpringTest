package com.sheena.SpringTest.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping("/input")
	public String addView() {
		return "lesson04/test01/test01_input";
	}
	
	@Autowired
	private SellerBO sellerBO;
	
	// INSERT
	@ResponseBody
	@RequestMapping("/add_seller")
	public String addSeller(
		@RequestParam("name") String nickname,
		@RequestParam("profileUrl") String profileImageUrl,
		@RequestParam("temperature") double temperature) {
		
		int count = sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "입력 성공 : " + count;
	}
		

	
	// 2. seller 출력		
	
	@RequestMapping("/seller_info")
	public String getSellerView(Model model) {
		SellerModel seller = sellerBO.getLastSeller();
		
		model.addAttribute("result", seller);
		
		return "lesson04/test01/test01_sellerInfo";
	}
	
	
	
	// 3. seller 검색 출력
	@ResponseBody
	public String seller(@RequestParam(value="id", required=false) Integer id) {
		
		if(id == null) {
			return "lesson04/test01/test01_sellerInfo";
		}
		
		return "lesson04/test01/test01_sellerInfo";
			
		// return sellerBO.getSeller(id);
		
	}
	
	
	

}
