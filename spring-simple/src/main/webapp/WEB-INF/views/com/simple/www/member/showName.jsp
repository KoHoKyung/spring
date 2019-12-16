<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/www/css/w3.css">
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js">
	
</script>
<style>
.w90 {
	display: inline-block;
	width: 90px;
}

.w80 {
	width: 80px;
}
</style>
<script type="text/javascript">
	$(function() {
		
		if(${bmno} == 1){
			alert("글은 한번만 등록가능합니다");
		}
		$('.btn1').click(function() {
			var tid = $(this).attr('id');
			var target = '';
			if (tid == 'login') {
				target = '/www/member/login.van';
			} else if (tid == 'logout') {
				target = '/www/member/logout.van';
			} else if (tid == 'home') {
				target = '/www';
			} 
			$(location).attr('href', target);
		});
		
		$('#write').click(function () {
			$('.visit').css('display', 'block');
		});
		$('#cancle').click(function () {
			$('.visit').css('display', 'none');
		});
		$('#load').click(function () {
			$('.visit').css('display', 'none');
	/* 		var m_id = $('#m_id').attr('id');
			var b_body = $('#b_body').text();
			alert(b_body);
			alert(m_id);
			$.ajax({
				url : "/www/board/visitorEdit.van",
				type : "POST",
				dataType : "json",
				data : 
					
			}) */
		});
	$('.pbutton').click(function () {
		var sPage = $(this).text();
		var sp = $('#startbtn').html();
		var rp = $('#endbtn').html();
		alert(sp);
		if(sPage != sp || sPage != rp){
			$('#nowPage').val(sPage);

		}
		if(sPage == sp){
			if('${PAGE.startPage}' == 1){
				return;
			}
			sPage = '${PAGE.startPage - 1}';
			$('#nowPage').val(sPage);

		}
		if(sPage == rp){
			if('${PAGE.endPage}' == '${PAGE.totalPage}'){
				return;
			}
			sPage = '$(PAGE.endPage + 1)';
			$('#nowPage').val(sPage);
		}
			$('#frm').submit();
	});
	
	});
</script>
</head>
<body>
	<form method="post" action="/www/board/visitorEdit.van" id="frm">
		<input type="hidden" name="nowPage" id="nowPage">
		<input type="hidden" name="m_id" value="${SID}">
	<div class="w3-col m3">
		<p></p>
	</div>
	<div class="w3-col m6">
		<h2 class="w3-container w3-margin-top w3-purple w3-card">댓글 게시판</h2>
		<div>
			<div class="w3-button w3-midium w3-green w3-left btn1" id="home">home</div>
			<c:if test="${empty SID }">
				<div class="w3-button w3-midium w3-lime w3-left btn1" id="login">login</div>
			</c:if>
			<c:if test="${not empty SID }">
				<div class="w3-button w3-midium w3-green w3-left btn1" id="logout">logout</div>
				<div class="w3-button w3-midium w3-green w3-right" id="write">글쓰기</div>
			</c:if>
		</div>	
		<div class="w3-col visit" style="display: none;">
				<textarea rows="10" cols="100%" class="w3-col w3-padding w3-margin-top" name="b_body"></textarea>
				<button class="w3-button w3-midium w3-red w3-right" id="load" type="submit">저장</button>
				<div class="w3-button w3-midium w3-blue w3-right" id="cancle">취소</div>
	</div>
		<div class="w3-col w3-container w3-margin-top">
			<c:forEach var="data" items="${LIST}">
			
					<div class="w3-container w3-card w3-margin-top">
						<div class="w3-col w90 w3-center w3-margin-top">
							<div class="w3-content w3-circle">
								<img src="/www/img/avatar/${data.a_img} " class="w80 w3-circle">
							</div>
							<h6>${data.m_id}</h6>
							
						</div>
						<div class="w3-rest lpad25">
							<h6 class="w3-col m3">${data.b_date}<small></small></h6><%--  ${data.wTime }--%>
			


							<hr class="w3-col" style="margin-top: 0px;">
							
							<div class="w3-container">${data.b_body}</div>
							<button class="w3-button w3-tiny w3-red w3-right">삭제</button>
							<button class="w3-button w3-tiny w3-red w3-right">수정</button>
						</div>
					</div>
				
			</c:forEach>
		</div>
		<div class="w3-center">
			<div class="w3-bar w3-border w3-margin-top w3-margin-bottom">
				  <div class="w3-bar-item w3-button w3-hover-blue pbutton " id="startbtn">&laquo;</div>
				
				 <c:forEach var="page" begin="${PAGE.startPage}" end="${PAGE.endPage}">
					  <div class="w3-bar-item w3-button w3-hover-blue pbutton">${page}</div>
				</c:forEach>
				<div class="w3-bar-item w3-button w3-hover-blue pbutton" id="endbtn">&raquo;</div>
			

			</div>
		</div>
	</div>
</form>
</body>
</html>