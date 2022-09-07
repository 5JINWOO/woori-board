// 글 등록시 유효성 검사
function saveCheckForm() {

	let boardTitle = document.boardins.boardTitle;

	if (boardTitle.value == '') {
		window.alert("제목을 입력하시오");
		document.boardins.boardTitle.focus();

		return false;
	}
	
	var boardName = document.boardins.boardName;

	if (boardName.value == '') {
		window.alert("작성자를 입력하시오");
		document.boardins.boardName.focus();

		return false;
	}
	
	var boardContents = document.boardins.boardContents;

	if (boardContents.value == '') {
		window.alert("내용을 입력하시오");
		document.boardins.boardContents.focus();

		return false;
	}
}

//글 수정시 유효성 검사
function updCheckForm() {

	let boardTitle = document.boardupd.boardTitle;

	if (boardTitle.value == '') {
		window.alert("제목을 입력하시오");
		document.boardupd.boardTitle.focus();

		return false;
	}
	
	var boardName = document.boardupd.boardName;

	if (boardName.value == '') {
		window.alert("작성자를 입력하시오");
		document.boardupd.boardName.focus();

		return false;
	}
	
	var boardContents = document.boardupd.boardContents;

	if (boardContents.value == '') {
		window.alert("내용을 입력하시오");
		document.boardupd.boardContents.focus();

		return false;
	}
}









