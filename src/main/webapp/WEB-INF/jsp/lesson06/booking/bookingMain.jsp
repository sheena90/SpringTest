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
		<section class="banner">
        	<img src="/img/lesson06/booking/test06_banner1.jpg">
        </section>
        <section class="d-flex">
        	<article class="reservation d-flex justify-content-center align-items-center">
            	<div class="display-4">
                	실시간 <br>
                    예약 하기 
                </div>
            </article>
            <article class="reservation-confirm">
            	<div class="m-4">
                	<div class="d-flex align-items-end">
                    	<h3 class="mr-4">예약 확인</h3>
                    </div>
                    <div class="member-input mt-3">
                    	<div class="input-gorup form-inline">
                        	<label class="input-label">이름 </label>
                        	<input type="text" class="form-control text-input" id="nameInput">
                       	</div>
                        <div class="input-gorup form-inline mt-3">
                        	<label class="input-label">전화번호 </label>
                            <input type="password" class="form-control text-input" id="phoneNumberInput">
                        </div>
                   	</div>
                    <div class="d-flex justify-content-end">
                    	<button class="btn btn-success mt-3 mr-5" id="lookupBtn">조회 하기</button>
                    </div>
            	</div>
            </article>
            <article class="reservation-call d-flex justify-content-center align-items-center">
            	<div>
	                <h3>예약문의 : </h3>
	                <h1>010-</h1>
	                <h1>0000-1111</h1>
                </div>
            </article>
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
			$("#lookupBtn").on("click", function(){
				let name = $("#nameInput").val();
				let phoneNumber = $("#phoneNumberInput").val();
				
				// 유효성 검사
				if(name == "") {
					alert("이름을 입력하세요.")
					return;
				}
				
				if(phoneNumber == "") {
					alert("전화번호를 입력하세요.")
					return;
				}
				
				$.ajax({
					type:"get",
					url:"/lesson06/booking",
					data:{"name":name, "phoneNumber":phoneNumber},
					success:function(data) {
						if(data == "") {
							alert("예약 내역이 없습니다.");
						} else {
							
							alert("이름 : " + data.name + "\n"
									+ "날짜 : " + data.date.slice(0,10) + "\n"
									+ "일수 : " + data.day + "\n"
									+ "인원 : " + data.headcount + "\n"
									+ "상태 : " + data.state);
						}
					},
					error:function() {
						alert("조회 에러");
					}
				});
				
			});
		});
	</script>

</body>
</html>