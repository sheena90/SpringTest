package com.sheena.SpringTest.lesson06.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sheena.SpringTest.lesson06.dao.BookingDAO;
import com.sheena.SpringTest.lesson06.model.BookingModel;

@Service
public class BookingBO {

	
	@Autowired
	private BookingDAO bookingDAO;
	
	
	// 예약 목록 페이지
	public List<BookingModel> getBookingList() {
		return bookingDAO.selectBookingList();
	}
	
	
	// 삭제
	public int deleteBooking(int id) {
		return bookingDAO.delete(id);
	}
	
	
	// 입력
	public int addBooking(String name, String date, int day, int headcount, String phoneNumber) {
		return bookingDAO.insertBooking(name, date, day, headcount, phoneNumber, "대기중");
	}
	
	
	// 예약 조회	
	public BookingModel getBooking(String name, String phoneNumber) {
		return bookingDAO.selectBooking(name, phoneNumber);
	}
	
	
	// 예약목록 페이지 예약상태 바꾸기
	public int stateChange(int id) {
		return bookingDAO.updateState(id);
	}
	
}
