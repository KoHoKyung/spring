<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login Test 1st</title>

<c:if test="${not empty SID}">
	<meta http-equiv="Refresh" content="3;url=/" />
</c:if>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/www/css/w3.css">
<script type="text/javascript" src="/www/js/jquery-3.4.1.min.js"></script>
<style>
</style>
<script type="text/javascript">
	var sid = '${SID}';
	$(function() {
		/* if(!sid || sid.length != 0){
			$(location).attr('href', '/www/main.van');
		} */

		$('#home').click(function() {
			$(location).attr('href', '/www/main.van');
		});
	});
</script>
</head>
<body class="w3-teal">
	<div class="w3-col m3 w3-margin-top">
		<p></p>
	</div>
	<!-- 로그인 폼 페이지 -->
	<c:if test="${empty SID}">
		<form method="POST" action="/www/member/loginProc.van" id="frm"
			class="w3-col m6 w3-center w3-margin-top">

			<button type="button" id="home" class="w3-left w3-indigo w3-button">메인화면</button>
			<div class="w3-col w3-padding-16 w3-green w3-margin-top w3-pale-blue"><h1>로 그 인</h1>
				<div class="w3-col w3-padding-16">
					I D : <input type="text" id="id" name="m_Id" style="width: 50%; height: 40px;" placeholder="아이디를 입력하세요">
				</div>
				<div class=" w3-padding-16">
					PW : <input type="password" id="pw" name="m_Pw" style="width: 50%; height: 40px;" placeholder="비밀번호를 입력하세요">
				</div>

				<button type="submit" id="btn" class="w3-col m6 w3-center w3-padding-16 w3-teal w3-margin-top w3-button" style="margin-left: 27%;">로그인</button>

			</div>


		</form>
	</c:if>

	<c:if test="${not empty SID}">
		<div class="w3-col m6 w3-center" id="d1">
			<h3>${SID}님은 이미로그인 했습니다.</h3>
			<h6>메인 페이지로 이동합니다.</h6>
		</div>
	</c:if>
</body>
</html>