<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>날씨 입력</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">   
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	
	
	<style>
		#wrap {width:1200px; margin:auto;}
		.logo {width:200px; height:100px; background:#6495ec;}
		.menu {width:200px; height:703px; background:#6495ec;}
		.content1 {width:1000px; height:50px;}
		
		header {height:100px;}
	</style>
</head>
<body>
	<div id="wrap">
		<div class="d-flex">
			<div>      
				<header class="logo">
				</header>
				<jsp:include page="menu.jsp" />
			</div>
			<div>
				<section class="contents">
					<div class="content1 d-flex align-items-center">
						<h2 class="ml-5">과거날씨</h2>
					</div>
					<div class="conten2">
						<table class="table text-center ml-5">
							<thead>
								<tr>
									<th>날짜</th>
									<th>날씨</th>
									<th>기온</th>
									<th>강수량</th>
									<th>미세먼지</th>
									<th>풍속</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="item" items="${weatherhistory }" >
								<tr>
									<td><fmt:formatDate value="${item.date }" pattern="yyyy년 M월 d일"/></td>
									<td>${item.weather }</td>
									<td>${item.temperatures }°C</td>
									<td>${item.precipitation }mm</td>
									<td>${item.microDust }</td>
									<td>${item.windSpeed }km/h</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
					<hr class="hr">
				</section>
			</div>
		</div>

		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>