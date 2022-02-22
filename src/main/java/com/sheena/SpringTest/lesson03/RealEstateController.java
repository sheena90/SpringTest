package com.sheena.SpringTest.lesson03;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheena.SpringTest.lesson03.bo.RealEstateBO;
import com.sheena.SpringTest.lesson03.model.RealEstateModel;

@Controller
@RequestMapping("/lesson03")
public class RealEstateController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	
	// SELECT 다루기
	
	// 1. id로 SELECT 하기
	
	@ResponseBody
	@RequestMapping("/test01/1")
	public RealEstateModel realEstate(@RequestParam(value="id", defaultValue="1")int id) {
		
		return realEstateBO.getRealEstate(id);
	}
	
	
	// 2. 월세 조건 SELECT
	
	@ResponseBody
	@RequestMapping("/test01/2")
	public List<RealEstateModel> realEstateByRentPrice(@RequestParam("rent")int rentPrice) {
		
		return realEstateBO.getRealEstateByRentPrice(rentPrice);
	}
	
	
	// 3. 복합조건 SELECT
	
	@ResponseBody
	@RequestMapping("/test01/3")
	public List<RealEstateModel> realEstateByAreaPrice(
			@RequestParam("area") int area,
			@RequestParam("price") int price) {
		
		return realEstateBO.getRealEstateByAreaPrice(area, price);
		
	}
	
	
	
	
	// INSERT 다루기 연습문제
	
	// 1. 객체로 INSERT 하기
	
	@ResponseBody
	@RequestMapping("/test02/1")
	public String addRealEstate() {
		
		RealEstateModel realEstate = new RealEstateModel();
		realEstate.setRealtorId(3);
		realEstate.setAddress("푸르지용 리버 303동 1104호");
		realEstate.setArea(89);
		realEstate.setType("매매");
		realEstate.setPrice(100000);
		
		int count = realEstateBO.addRealEstate(realEstate);
		
		return "입력 성공 : " + count;
	}
	
	
	
	// 2. field로 insert 하기
	
	@ResponseBody
	@RequestMapping("/test02/2")
	public String addRealEstateWithParameter(@RequestParam("realtorId") int realtorId) {
		
		int count = realEstateBO.addRealEstateField(realtorId, "썅떼빌리버 오피스텔 814호", 45, "월세", 100000, 120);
		
		return "입력 성공 : " + count;
	}
	
	
	
	
	// UPDATE 다루기 연습문제
	
	@ResponseBody
	@RequestMapping("/test03")
	public String updateRealEstate() { // 전달 받을 것이 없어서 @RequestParam 필요 없음
		
		int count = realEstateBO.updateRealEstateField(23, "전세", 70000);
		
		return "수정 성공 : " + count;
	}
	
	
	
	
	// DELETE 다루기 연습문제

	@ResponseBody
	@RequestMapping("/test04")
	public String deleteRealEstaParameter(@RequestParam("id") int id) {
		
		int count = realEstateBO.getDeleteRealEstate(id);
		
		return "삭제 성공 : " + count;
	}
	
}
