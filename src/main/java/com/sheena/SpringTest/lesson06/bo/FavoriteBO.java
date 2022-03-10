package com.sheena.SpringTest.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheena.SpringTest.lesson06.dao.FavoriteDAO;
import com.sheena.SpringTest.lesson06.model.FavoriteModel;

@Service
public class FavoriteBO {
	
	@Autowired
	private FavoriteDAO favoriteDAO;
	
	
	public int addFavorite(String name, String url) {
		return favoriteDAO.insertFavorite(name, url);
	}
	
	
	
	public List<FavoriteModel> getFavoriteList() {
		return favoriteDAO.selectFavoriteList();
	}
	
	
	// 중복 체크
	public boolean duplicate(String url) {
		
		int count = favoriteDAO.selectUrlCount(url);
		
		return count != 0;
	}
	
	
	// 삭제
	public int deleteFavorite(int id) {
		return favoriteDAO.deleteFavorite(id);
	}

}
