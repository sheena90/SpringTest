package com.sheena.SpringTest.lesson04.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sheena.SpringTest.lesson04.model.SellerModel;

@Repository
public interface SellerDAO {
	
	// 1. seller 추가
	
	// INSERT
	public int insertSeller(
			@Param("name") String nickname,
			@Param("profileUrl") String profileImageUrl,
			@Param("temperature") double temperature);
		
	
	
	// 2. seller 출력	

	public SellerModel selectLastSeller();
	
	
	
	// 3. seller 검색 출력
	
	public SellerModel selectSeller(@Param("id") int id);
}
