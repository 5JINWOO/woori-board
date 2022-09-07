<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../common/nav.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${path}/resources/js/board.js"></script>
<title>게시글 수정</title>
</head>
<body>
	<div class="container">
		<h1>게시글 수정</h1>
		<form action="/board/boardMerge" method="post" name="boardupd" onsubmit="return updCheckForm();">
			<input type="hidden" value="${seq.boardNo}" name="boardNo" id="seq">
			<div class="form-group">
				<label for="exampleFormControlInput1" class="form-label">제목</label>
				<input type="text" class="form-control"
					id="exampleFormControlInput1"value="${seq.boardTitle}"
					name="boardTitle">
			</div>
			<div class="form-group">
				<label for="exampleFormControlInput2" class="form-label">작성자</label>
				<input type="text" class="form-control"
					id="exampleFormControlInput2" value="${seq.boardName}"
					name="boardName">
			</div>
			<div class="form-group">
				<label for="exampleFormControlTextarea1" class="form-label">내용</label>
				<textarea class="form-control" id="exampleFormControlTextarea1"
					name="boardContents" rows="7">${seq.boardContents}</textarea>
			</div>
			<div class="form-group">
			<button type="submit" class="btn btn-info">수정</button>
			<button type="button" class="btn btn-primary" onclick="location.href='/board/boardList'">목록</button>
			</div>
		</form>
	</div>

</body>
</html>