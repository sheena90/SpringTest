package com.sheena.SpringTest.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheena.SpringTest.lesson04.dao.SellerDAO;
import com.sheena.SpringTest.lesson04.model.SellerModel;

@Service
public class SellerBO {
	
	@Autowired
	private SellerDAO sellerDAO;
	
	// 1. seller 추가
	
	// INSERT
	public int addSeller(String nickname, String profileImageUrl, double temperature) {
		
		return sellerDAO.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	
	
	
	// 2. seller 출력	
	
	public SellerModel getLastSeller() {
		return sellerDAO.selectLastSeller();
	}
	
	
	
	// 3. seller 검색 출력
	
	public SellerModel getSeller(int id) {
		
		return sellerDAO.selectSeller(id);
	}

}
