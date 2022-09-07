<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../common/nav.jsp"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세화면</title>
</head>
<body>
	<div class="container">
		<h1>게시글 상세</h1>  <!-- form-group :margin-bottom:15px -->
		
		<div class="form-group"><strong>번호</strong> ${seq.boardNo}</div>
		<div class="form-group"><strong>제목</strong> ${seq.boardTitle}</div>
		<div class="form-group"><strong>작성자</strong> ${seq.boardName}</div>
		<div class="form-group"><strong>내용</strong> </div>
		<div class="form-group">${seq.boardContents}</div>
		<div class="form-group">
		<button type="button" class="btn btn-info" onclick="location.href='/board/updateView?boardNo=${seq.boardNo}'">수정</button>
		<button type="button" class="btn btn-danger" onclick="location.href='/board/boardDelete?boardNo=${seq.boardNo}'">삭제</button>
		<button type="button" class="btn btn-primary" onclick="location.href='/board/boardList'">목록</button></div>
	</div>
</body>
</html>