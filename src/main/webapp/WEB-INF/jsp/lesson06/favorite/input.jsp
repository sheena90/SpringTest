<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">   
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	

</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<label class="mt-3">제목</label>
		<div>
			<input type="text" class="form-control" id="nameInput">
		</div>
		<label class="mt-3">주소</label>
		<div class="d-flex">
			<input type="text" class="form-control" id="urlInput">
			<button type="button" class="btn btn-info ml-3" id="duplicateBtn">중복체크</button>
		</div>
		<div><small class="text-success d-none" id="possibleText">저장 가능한 url 입니다.</small></div>
		<div><small class="text-danger d-none" id="impossibleText">중복된 url입니다.</small></div>
		<div class="mt-3">
			<button type="button" class="btn btn-success form-control" id="addBtn">추가</button>
		</div>	
	</div>


	<script>
		$(document).ready(function() {
			// 중복 체크를 했는지 여부 저장하는 변수
			var isChecked = false;
			
			// 중복된 상태인지 확인하는 변수
			var isDuplicate = true;
			
			$("#addBtn").on("click",function() {
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				
				
				// 유효성 검사
				if(name == "") {
					alert("이름을 입력하세요.");
					return;
				}
				
				if(url == "") {
					alert("주소를 입력하세요.");
					return;
				}
				
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
					alert("주소 형식이 잘 못 되었습니다.");
					return;
				}
				
				if(isChecked == false) {
					alert("중복 확인을 진행해 주세요.");
					 return;
				}
				
				if(isDuplicate) {
					alert("url이 중복되었습니다.");
					 return;
				}
				
				
				// ajax를 통한 api 호출
				
				$.ajax({
					type:"get",
					url:"/lesson06/add_favorite",
					data:{"name":name, "url":url},
					success:function(data) {
						
						// success
						if(data.result == "success") {
							location.href = "/lesson06/list";
						} else {
							alert("즐겨찾기 추가 실패")
						}
						
						// fail
					},
					error:function() {
						alert("다시 입력해주세요.");
					}
					
				});
				
			});
			
			
			// 중복 체크
			$("#duplicateBtn").on("click", function(){
				
				let url = $("#urlInput").val();
				
				if(url == "") {
					alert("주소를 입력하세요.");
					return;
				}
				
				if(!url.startsWith("http://") && !url.startsWith("https://")) {
					alert("주소 형식이 잘 못 되었습니다.");
					return;
				}
				
				$.ajax({
					type:"get",
					url:"/lesson06/duplicate",
					data:{"url":url},
					success:function(data) {
						
						// 중복체크 완료
						isChecked = true;
						
						//안내 텍스트를 숨기기
						$("#possibleText").addClass("d-none");
						$("#impossibleText").addClass("d-none");
						
						if(data.duplicate) {
							// 중복 안내 텍스트를 보여주기
							$("#impossibleText").removeClass("d-none");
						} else {
							// 사용 가능 안내 텍스트를 보여주기
							isDuplicate = false;
							$("#possibleText").removeClass("d-none");
						}
					},
					error:function() {
						alert("중복체크 에러");
					}
				});
			});
			
			
			// url 입력내용 수정
			$("#urlInput").on("input", function() {
				// 중복 관련 변수 값 초기화
				isChecked = false;
				isDuplicate = true;
				
				// 중복 관련 텍스트 숨기기
				$("#possibleText").addClass("d-none");
				$("#impossibleText").addClass("d-none");
			});
		});
	
	</script>
</body>
</html>