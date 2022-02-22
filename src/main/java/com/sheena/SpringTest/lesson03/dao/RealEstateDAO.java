package com.sheena.SpringTest.lesson03.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sheena.SpringTest.lesson03.model.RealEstateModel;

@Repository
public interface RealEstateDAO {

	
	// SELECT 다루기
	
	// 1. id로 SELECT 하기
	
	public RealEstateModel selectRealEstate(@Param("id") int id);
	
	
	
	// 2. 월세 조건 SELECT
	
	public List<RealEstateModel> selectRenPrice(@Param("rent") int rentPrice);
	
	
	
	// 3. 복합 조건 SELECT
	
	public List<RealEstateModel> selectAreaPrice(
			@Param("area") int area, 
			@Param("price") int price);
	
	
	
	
	
	// INSERT 다루기 연습문제
	
	// 1. 객체로 INSERT 하기
	
	public int insertRealEstate(RealEstateModel realEstate);
	
	
	
	// 2. field로 insert 하기
	
	public int insertRealEstateField(
			@Param("realtorId") int realtorId,
			@Param("address") String address,
			@Param("area") int area,
			@Param("type") String type,
			@Param("price") int price,
			@Param("rentPrice") int rentPrice);
	
	
	
	
	// UPDATE 다루기 연습문제
	
	public int updateRealEstate(
			@Param("id") int id,
			@Param("type") String type,
			@Param("price") int price);
	
	
	
	
	// DELETE 다루기 연습문제
	
	public int deleteRealEstateFied(@Param("id") int id);
	

	
}
