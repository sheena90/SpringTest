<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
		.menu {width:200px; height:300px; background:#6495ec;}
		.content1 {width:1000px; height:150px;}
		.content2 {width:1000px; height:100px;}
		.content3 {width:1000px; height:100px;}
		header {height:100px;}
		nav {height:100px;}
	</style>
</head>
<body>
	<div id="wrap">
		<div class="d-flex">
			<div>
				<header class="logo">
				</header>
				<nav class="menu">
					<ul class="nav flex-column">
						<li class="nav-item"><a class="nav-link text-white font-weight-bold" href="#">날씨</a></li>
						<li class="nav-item"><a class="nav-link text-white font-weight-bold" href="#">날씨입력</a></li>
						<li class="nav-item"><a class="nav-link text-white font-weight-bold" href="#">테마날씨</a></li>
						<li class="nav-item"><a class="nav-link text-white font-weight-bold" href="#">관측기후</a></li>
					</ul>
				</nav>
			</div>
			<div>
				<section class="contents">
					<div class="content1 d-flex">
						<h2 class="ml-5 font-weight-bold">날씨입력</h2>
					</div>
					<div class="content2 bg-info d-flex align-items-center">
						<div class="d-flex col-4 justify-content-end align-items-center bg-success">
							<label class="mr-2">날짜</label>
							<input type="text" class="form-control col-8">
						</div>
						<div class="d-flex col-4 align-items-center bg-warning">
							<label class="mr-2">날씨</label><input type="text" class="form-control col-6">
						</div>
						<div class="d-flex align-items-center  justify-content-end bg-danger col-4">
							<label class="col-4">미세먼지</label>
	            			<input type="text" class="form-control col-8">
	        			</div>  
					</div>
					<div class="content3 bg-warning d-flex">
						<div class="input-group d-flex align-items-center">
							<div>날짜</div>
	            			<div><input type="text" class="form-control"></div>
	            			<div class="input-group-append">
	            				<span class="input-group-text">°C</span>
	            			</div>
	        			</div>
	        			<div class="input-group d-flex align-items-center ">
							<label>날짜</label>
	            			<input type="text" class="form-control">
	            			<div class="input-group-append">
	            				<span class="input-group-text">°C</span>
	            			</div>
	        			</div>
	        			<div class="input-group d-flex align-items-center">
							<label>날짜</label>
	            			<input type="text" class="form-control">
	            			<div class="input-group-append">
	            				<span class="input-group-text">°C</span>
	            			</div>
	        			</div>  
	        		</div>
	        		<div class="d-flex justify-content-end">
	        			<button class="btn btn-success">저장</button>
	        		</div>

				</section>
			</div>
		</div>
		
		<jsp:include page="footer.jsp" />
	</div>

</body>
</html>