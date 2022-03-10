package com.sheena.SpringTest.lesson06.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sheena.SpringTest.lesson06.model.FavoriteModel;

@Repository
public interface FavoriteDAO {

	public int insertFavorite(
			@Param("name") String name,
			@Param("url") String url);
	
	
	
	
	public List<FavoriteModel> selectFavoriteList();
	
	
	
	
	
	// 중복 체크
	public int selectUrlCount(@Param("url") String url);
	
	
	
	
	// 삭제
		public int deleteFavorite(@Param("id") int id);
}





	