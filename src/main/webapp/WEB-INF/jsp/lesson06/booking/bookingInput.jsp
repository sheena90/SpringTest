<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 목록 보기</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">   
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
    <link rel="stylesheet" href="/css/lesson06/booking/style.css" type="text/css">
    
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</head>
<body>
	<div id="wrap">
		<header class="mt-4">
			<div class="text-center display-4"><a class="nav-link text-dark" href="/lesson06/booking_select">통나무 팬션</a></div>
		</header>
		<nav class="mt-4">
			<ul class="nav nav-fill">
            	<li class="nav-item"><a class="nav-link" href="#">팬션소개</a></li>
                <li class="nav-item"><a class="nav-link" href="#">객실보기</a></li>
                <li class="nav-item"><a class="nav-link" href="/lesson06/booking_input">예약하기</a></li>
                <li class="nav-item"><a class="nav-link" href="/lesson06/booking_list">예약목록</a></li>
            </ul>
		</nav>
		<section>
			<div class="text-center mt-4">
				<h2>예약하기</h2>
			</div>
			<div class="info mt-4">
				<div class="mt-3">
					<label>이름</label>
					<div><input type="text" class="form-control" id="nameInput"></div>
				</div>
				<div class="mt-3">
					<label>예약날짜</label>
					<div><input type="text" class="form-control" id="dateInput"></div>
				</div>
				<div class="mt-3">
					<label>숙박일수</label>
					<div><input type="text" class="form-control" id="dayInput"></div>
				</div>
				<div class="mt-3">
					<label>숙박인원</label>
					<div><input type="text" class="form-control" id="headcountInput"></div>
				</div>
				<div class="mt-3">
					<label>전화번호</label>
					<div><input type="text" class="form-control" id="phoneNumberInput"></div>
				</div>
				<div class="mt-3">
					<button type="button" class="btn form-control" id="addBtn">예약하기</button>
				</div>
			</div>
		</section>
		<footer class="mt-3 ml-4">
        	<address>
            	제주특별자치도 제주시 애월읍  <br>
                사업자등록번호: 111-22-255222 / 농어촌민박사업자지정 / 대표:김통목 <br>
                Copyright 2025 tongnamu All right reserved
            </address>
        </footer>
	</div>
	
	
	<script>
		$(document).ready(function(){
			
			$("#dateInput").datepicker({
                changeMonth: true,  // 월 셀렉트 박스 
                changeYear: true,   // 년 셀렉트 박스 
                dateFormat:"yy-mm-dd",  // 표시 포멧 
                minDate:0
            });
			
			$("#addBtn").on("click", function(){
				let name = $("#nameInput").val();
				let date = $("#dateInput").val();
				let day = $("#dayInput").val();
				let headcount = $("#headcountInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				
				// 유효성 검사
				if(name == "") {
					alert("이름을 입력하세요.")
					return;
				}
				
				if(date == "") {
					alert("예약날짜를 입력하세요.")
					return;
				}
				if(day == "") {
					alert("숙박일수를 입력하세요.")
					return;
				}
				
				// 숙박일수를 숫자가 아닌 것을 입력한 경우
				if(isNaN(day)) {
					alert("숙박일수는 숫자만 입력 가능합니다.");
					return;
				}
				
				if(headcount == "") {
					alert("숙박인원을 입력하세요.")
					return;
				}
				
				// 숙박인원을 숫자가 아닌 것을 입력한 경우
				if(isNaN(headcount)) {
					alert("숙박인원은 숫자만 입력 가능합니다.");
					return;
				}
				
				if(phoneNumber == "") {
					alert("전화번호를 입력하세요.")
					return;
				}
				
				// ajax를 통한 api 호출
				$.ajax({
					type:"get",
					url:"/lesson06/add_booking",
					data:{"name":name,
						  "date":date,
						  "day":day,
						  "headcount":headcount,
						  "phoneNumber":phoneNumber},
					success:function(data) {
						if(data.result == "success") {
							location.href = "/lesson06/booking_list";
						} else {
							alert("예약하기 실패");
						}
					},
					error:function() {
						alert("다시 입력해주세요.");
					}
				});
			});
		});
	</script>

</body>
</html>