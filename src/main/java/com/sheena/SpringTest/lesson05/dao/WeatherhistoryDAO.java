package com.sheena.SpringTest.lesson05.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sheena.SpringTest.lesson05.model.WeatherhistoryModel;

@Repository
public interface WeatherhistoryDAO {
	
	// select
	public List<WeatherhistoryModel> selectWeatherhistory();
	
	
	// insert
	public int insert(
			@Param("date") Date date,
			@Param("weather") String weather,
			@Param("temperatures") double temperatures,
			@Param("precipitation") double precipitation,
			@Param("microDust") String microDust,
			@Param("windSpeed") double windSpeed);
	

}
