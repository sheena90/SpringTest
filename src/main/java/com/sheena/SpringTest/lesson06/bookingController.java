package com.sheena.SpringTest.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheena.SpringTest.lesson06.bo.BookingBO;
import com.sheena.SpringTest.lesson06.model.BookingModel;

@Controller
@RequestMapping("/lesson06")
public class bookingController {
	
	@Autowired
	private BookingBO bookingBO;
	
	// 예약 목록 페이지
	@GetMapping("/booking_list")
	public String bookingList(Model model) {
		List<BookingModel> bookingList = bookingBO.getBookingList();
		
		model.addAttribute("booking", bookingList);
		
		return "lesson06/booking/bookingList";
	}
	
	
	// 삭제
	@GetMapping("/booking_delete")
	@ResponseBody
	public Map<String, String> delete(@RequestParam("id") int id) {
		
		int count = bookingBO.deleteBooking(id);
		
		Map<String, String> result = new HashMap<>();
		
		if(count == 1) {
			result.put("result", "success");
		} else {
			result.put("result", "fail");
		}
		
		return result;
	}
	
	
	// 예약하기
	@GetMapping("/booking_input")
	public String input() {
		return "lesson06/booking/bookingInput";
	}
	
	
	// 입력
	@GetMapping("/add_booking")
	@ResponseBody	
	public Map<String, String> addBooking (
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber) {
		
		int count = bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		
		Map<String, String> resultMap = new HashMap<>();
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	
	
	
	// 예약 조회
	@GetMapping("/booking_select")	
	public String bookingSelect(
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="phoneNumber", required=false) String phoneNumber,
			Model model) {
		
		if(name != null || phoneNumber != null) {
			
			BookingModel bookingSelect = bookingBO.getBooking(name, phoneNumber);
			model.addAttribute("booking", bookingSelect);
			
		} else {
			
			
		}
		
		return "lesson06/booking/bookingMain";
	}
	
	
}
