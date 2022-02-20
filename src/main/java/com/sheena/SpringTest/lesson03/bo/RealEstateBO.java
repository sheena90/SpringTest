package com.sheena.SpringTest.lesson03.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheena.SpringTest.lesson03.dao.RealEstateDAO;
import com.sheena.SpringTest.lesson03.model.RealEstateModel;

@Service
public class RealEstateBO {

	@Autowired
	private RealEstateDAO realEstateDAO;
	
	
	// SELECT 다루기
	
	// 1. id로 SELECT 하기
	
	public RealEstateModel getRealEstate(int id) {
		
		return realEstateDAO.selectRealEstate(id);
	}
	
	
	
	// 2. 월세 조건 SELECT
	
	public List<RealEstateModel> getRealEstateByRentPrice(int rentPrice) {
		
		return realEstateDAO.selectRenPrice(rentPrice);
	}
	
	
	
	// 3. 복합조건 SELECT
	
	public List<RealEstateModel> getRealEstateByAreaPrice(int area, int price) {
		
		return realEstateDAO.selectAreaPrice(area, price);
	}
	
	
	
	
	
	// INSERT 다루기 연습문제
	
	// 1. 객체로 INSERT 하기
	
	public int addRealEstate(RealEstateModel realEstate) {
		return realEstateDAO.insertRealEstate(realEstate);
		
	}
	
	
	
	// 2. field로 insert 하기
	
	public int addRealEstateField(int realtorId, String address, int area, String type, int price, int rentPrice) {
		return realEstateDAO.insertRealEstateField(realtorId, address, area, type, price, rentPrice);
	}
	
	
	
	
	
	// UPDATE 다루기 연습문제
	
	public int updateRealEstateField(int id, String type, int price) {
		return realEstateDAO.updateRealEstateField(id, type, price);
	}
	
	
	
	
	
	// DELETE 다루기 연습문제
	
	public int getDeleteRealEstate(int id) {
		
		return realEstateDAO.deleteRealEstateFied(id);

	}
	
}
