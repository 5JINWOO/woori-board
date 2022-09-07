<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../common/nav.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${path}/resources/js/board.js"></script>
<title>게시글 목록</title>
</head>
<body>
	<form>
		<div class="container">
			<h1>게시판</h1>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${boardList}" var="list">
						<!-- items-반복처리할 집합체 var-변수이름을 String형으로 지정  -->
						<tr>
							<td>${list.boardNo}</td>
		 		            <td><a href="/board/boardDetail?boardNo=${list.boardNo}")>${list.boardTitle}</a></td>
							<td>${list.boardName}</td>
							<td>${list.regdate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="button" class=" btn btn-success" onclick="location.href='/board/saveView'">글쓰기</button>
		</div>
	</form>
</body>
</html>