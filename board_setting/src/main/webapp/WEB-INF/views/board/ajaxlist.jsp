<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <c:set var="cpath" value="${pageContext.request.contextPath}"/} --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../common/nav.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${path}/resources/js/boardAjax.js"></script>
<title>게시글 목록</title>
</head>
<body>
<div class="container">
		<form id="frm">
			<h1>Ajax 게시판</h1>
			<div class="wrap">
				<!-- 게시글 목록부분 -->
			</div>
			<button type="button" class=" btn btn-success" id="btn-save">글쓰기</button>
		</form>
		<div class="savview" >

		</div>
		<div class="detview" style="display:none">
			<div class="form-group">
				<strong>번호</strong>			
				<p class="deboardNo"></p>
			</div>
			<div class="form-group">
				<strong>제목</strong>			
				<p class="deboardTitle"></p>
			</div>
			<div class="form-group">
				<strong>작성자</strong>			
				<p class="deboardName"></p>
			</div>
			<div class="form-group">
				<strong>내용</strong>			
			    <p class="deboardContents"></p>
			</div>
			<button type="button" class="btn btn-primary" id="btn-close">닫기</button>
		</div>
</div>
</body>
</html>