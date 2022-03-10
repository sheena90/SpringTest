package com.sheena.SpringTest.lesson05;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheena.SpringTest.lesson05.bo.WeatherhistoryBO;
import com.sheena.SpringTest.lesson05.model.WeatherhistoryModel;

@Controller
@RequestMapping("/lesson05")
public class weatherhistoryController {	
	
	@Autowired
	private WeatherhistoryBO weatherhistoryBO;	
	
	// 데이터베이스 조회
	@GetMapping("/select")
	public String weatherHistory(Model model) {
	
		List<WeatherhistoryModel> weatherhistory = weatherhistoryBO.getWeatherhistory();
		
		model.addAttribute("weatherhistory", weatherhistory);
		
		return "lesson05/test05/weatherhistory";
		
	}
	
	// input
	@GetMapping("/input")
	public String weatherhistoryInput() {
		return "lesson05/test05/input";
	}

	
	// insert
	@ResponseBody
	@GetMapping("/insert")
	public String insert(
			@RequestParam("date") Date date,
			@RequestParam("weather") String weather,
			@RequestParam("temperatures") double temperatures,
			@RequestParam("precipitation") double precipitation,
			@RequestParam("microDust") String microDust,
			@RequestParam("windSpeed") double windSpeed) {
		
		int count = weatherhistoryBO.insert(date, weather, temperatures, precipitation, microDust, windSpeed);
		
		return "입력 성공 : " + count;
		
	}

}
