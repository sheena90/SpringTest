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
		<section>
			<div class="text-center mt-4">
				<h2>예약 목록 보기</h2>
			</div>
			<table class="table text-center mt-4">
				<thead>
					<tr>
						<th>이름</th>
						<th>예약날짜</th>
						<th>숙박일수</th>
						<th>숙박인원</th>
						<th>전화번호</th>
						<th>예약상태</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${booking }" varStatus="statu">
					<tr>
						<td>${item.name }</td>
						<fmt:parseDate value="${item.date }" pattern="yyyy-MM-dd" var="date" />
						<td><fmt:formatDate value="${date }" pattern="yyyy년 M월 dd일" /></td>
						<td>${item.day }</td>
						<td>${item.headcount }</td>
						<td>${item.phoneNumber }</td>
						<td>
							<c:choose>
								<c:when test="${item.state == '확정' }">
									<span class="text-success">${item.state }</span>
								</c:when>
								<c:when test="${item.state == '대기중' }">
									<span class="text-info">
										<a href="#" class="changeBtn" data-booking-id="${item.id }">${item.state }</a>
									</span>
								</c:when>
								<c:when test="${item.state == '취소' }">
									<span class="text-danger">${item.state }</span>
								</c:when>
								<c:otherwise>
									<span>${item.state }</span>
								</c:otherwise>
							</c:choose>
						</td>
						<td><button type="button" data-booking-id="${item.id }" class="btn btn-danger btn-sm deleteBtn">삭제</button></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
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
			// 삭제
			$(".deleteBtn").on("click", function(){
				
				let bookingID = $(this).data("booking-id");
				
				$.ajax({
					type:"get",
					url:"/lesson06/booking_delete",
					data:{"id":bookingID},
					success:function(data) {
						if(data.result == "success") {
							location.reload();
						} else {
							alert("삭제 실패");
						}
					},
					error:function(){
						alert("삭제 에러");
					}
				});
			});
			
			
			// 예약목록 페이지 예약상태 바꾸기
			$(".changeBtn").on("click", function(){
				
				let bookingID = $(this).data("booking-id");
				
				$.ajax({
					type:"get",
					url:"/lesson06/state_change",
					data:{"id":bookingID},
					success:function(data) {
						if(data.result == "success") {
							  location.reload();
						} else {
							alert("상태 변경 실패");
						}
					},
					error:function(){
						alert("상태 변경 에러");
					}
				});
			});
		});
	</script>

</body>
</html>