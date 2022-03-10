package com.sheena.SpringTest.lesson05.bo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheena.SpringTest.lesson05.dao.WeatherhistoryDAO;
import com.sheena.SpringTest.lesson05.model.WeatherhistoryModel;

@Service
public class WeatherhistoryBO {
	
	@Autowired
	private WeatherhistoryDAO weatherhistoryDAO;
	
	// select
	public List<WeatherhistoryModel> getWeatherhistory() {
		
		List<WeatherhistoryModel> weatherhistory = weatherhistoryDAO.selectWeatherhistory();
		return weatherhistory;
		
	}
	
	
	// insert
	public int insert(Date date, String weather, double temperatures, double precipitation, String microDust, double windSpeed) {
		
		return weatherhistoryDAO.insert(date, weather, temperatures, precipitation, microDust, windSpeed);
	}

}
