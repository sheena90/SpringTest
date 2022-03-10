package com.sheena.SpringTest.lesson06.dao;

import java.util.List;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.sheena.SpringTest.lesson06.model.BookingModel;

@Repository
public interface BookingDAO {

	// 예약 목록 페이지
	public List<BookingModel> selectBookingList();
	
	
	// 삭제
	public int delete(@Param("id") int id);
	
	
	// 입력
	public int insertBooking(
			@Param("name") String name,
			@Param("date") String date,
			@Param("day") int day,
			@Param("headcount") int headcount,
			@Param("phoneNumber") String phoneNumber);
	
	
	// 예약 조회
	public BookingModel selectBooking(
			@Param("name") String name,
			@Param("phoneNumber") String phoneNumber);
	
	
}
