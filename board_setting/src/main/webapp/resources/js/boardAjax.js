$(document).ready(function() {
		viewList();
		
		
		//글쓰기 버튼 이벤트
		$("#btn-save").on("click",()=>{
			console.log('글쓰기버튼');
			viewSave();			
		});
		
		//닫기 버튼 이벤트
		$("#btn-close").on("click",()=>{
			console.log('닫기버튼');
			$(".detview").hide(); //클릭시 display none
		});
		
		//전체 선택 이벤트
		$(document).on("click", "#allCheck", function(){  //동적으로 생성된 페이지 버튼 이벤트 형식
			var aa = $("#allCheck").is(":checked");
			console.log("aaaa==="+aa);
			if($("#allCheck").is(":checked")){
				$("input[name=rowCheck]").prop("checked", true);
			}
			else {
				$("input[name=rowCheck]").prop("checked", false);
			}
		});
		$(document).on("click", "input[name=rowCheck]", function(){  
			var total = $("input[name=rowCheck]").length;
			var checked = $("input[name=rowCheck]:checked").length;
			if(total != checked) {
				$("#allCheck").prop("checked", false);
			}
			else {
				$("#allCheck").prop("checked", true); 
			}
		});
});

var insertFormChk = true;  //save화면 출력 삭제를 결정해 줄 변수

// ajax 게시글 목록
function viewList(){	
		$.ajax({
				type : "GET",				
				url : "/board/ajaxList",
				dataType : 'json',
				success : function(data) {				
					if(data.length > 0) {
						
						var html = "<table class = 'table table-striped'>";
						html += "<tr>";
						html += "<th><input type='checkbox' id='allCheck'/>전체선택</th>";
						html += "<th>번호</th>";
						html += "<th>제목</th>";
						html += "<th>작성자</th>";
						html += "<th>날짜</th>";
						html += "</tr>";
						
						html += "<tr>";
						html += "<td colspan='5'><button type='button' class='btn btn-danger' onclick='delValue()'>선택삭제</button></td>";
						html += "</tr>";
						
						$.each(data, (index, data)=>{
							html += "<tr>";
							html += "<td><input type='checkbox' name='rowCheck' value="+data.boardNo+" '</td>";
							html += "<td>"+data.boardNo+"</td>";
							html += "<td><a href='#' onclick='viewDetail("+data.boardNo+")'>"+data.boardTitle+"</a></td>";
							html += "<td>"+data.boardName+"</td>";
							html += "<td>"+data.regdate+"<br><button type='button' class='btn btn-danger' onclick='delBoard("+data.boardNo+")'>삭제 </button></td>";
							html += "</tr>";
						})
						html+="</table>";
						
						$(".wrap").html(html);					
				    }
			    }
							
       });
}	




// 게시글 상세화면 
function viewDetail(boardNo) {	
	console.log("boardNo=="+boardNo);
	console.log(typeof boardNo);
		
	$.ajax({
		type : "POST",		
		url : "/board/ajaxDetail",
		data : {'boardNo' : boardNo},
		dataType : 'json',
		success : function(data) {
			console.log(data);
			$(".detview").show();
			$(".deboardNo").html(data.boardNo);
			$(".deboardTitle").html(data.boardTitle);
			$(".deboardName").html(data.boardName);
			$(".deboardContents").html(data.boardContents);
	    },
		error: function(data){
			alert("상세화면실패");
		}			
	}); 
}


//게시글 선택삭제 함수
function delValue() {
	var checked = $("input[name=rowCheck]:checked").length //check 아예없을때  확인용
	var arr = [];
	if(checked != 0){ 		
		$("input:checkbox[name=rowCheck]:checked").each(function() {   //체크된 네임 값을 가져와서 값 형태 확인후 반복문으로 돌려서 번호 주는거 확인)
			arr.push($(this).val());  //string				
		});
		alert(arr);	
		
		console.log(typeof arr);
		
		$.ajax({
			type : "POST",
//			traditional : true, //ajax 서버단으로 배열을 보낼때 사용 requestParam을 arr[]로 설정해주면 전통방식으로 간다
			data :{arr : arr},
			url : "/board/chkDelete",
			dataType : 'text',
			success: function(data) {
				console.log("data===="+data);
				alert("선택삭제성공");
				viewList();
			},
			error: function(data){
				if(data == "N") {
					alert("선택삭제실패");
					viewList();					
				}
			}			
		});		
	}else {
		alert('삭제할 대상을 체크하여 주십시오');
	}
}


// 게시글 삭제버튼 이벤트
function delBoard(boardNo){
	console.log("boardNo=="+boardNo);
	var result = confirm("삭제하시겠습니까?");
		
	if(result){
		$.ajax({
			type : "GET",
			data : {'boardNo' : boardNo},
			url : "/board/ajaxDelete",
			success: function(data) {
				if(data == "Y") {
					$(".detview").hide();
					viewList();					
				}
			},
			error: function(data){
				alert("삭제실패");
			}			
		});		
	 }
}

//글 등록 화면
function viewSave() {
	$(".detview").hide(); //상세화면 먼저 실행 시에 닫기버튼 안눌렀을 경우
	console.log('viewSave');
		var sav ="<form>";
		sav += "<div class='form-group'>";
		sav += "<label for='exampleFormControlInput1' class='form-label'>제목</label>";
		sav += "<input type='text' class='form-control'" +
				"id='exampleFormControlInput1' placeholder='제목을 입력하세요'" +
				"name='boardTitle'></div>";   
		
		sav += "<div class='form-group'>";
		sav += "<label for='exampleFormControlInput2' class='form-label'>작성자</label>";
		sav += "<input type='text' class='form-control'" +
				"id='exampleFormControlInput2' placeholder='작성자를 입력하세요'" +
				"name='boardName'></div>";
		
		sav += "<div class='form-group'>";
		sav += "<label for='exampleFormControlTextarea1' class='form-label'>내용</label>";
		sav += "<textarea class='form-control' id='exampleFormControlTextarea1'" +
				"id='exampleFormControlTextarea1' placeholder='내용을 입력하세요'" +
				"name='boardContents' rows='7'></textarea></div>";
		sav += "<button type='button' class='btn btn-info' onclick='saveAjax()'>작성</button>";		
		sav += "</form>";
		

		console.log("insertFormChk==="+insertFormChk);
		if(insertFormChk == true) {
			$(".savview").html(sav);
			insertFormChk = false;
		} else {

			$(".savview").empty();
			insertFormChk = true;
		}
}

//ajax 글등록
function saveAjax() {	
	var boardTitle = $("#exampleFormControlInput1").val();
	var boardName = $("#exampleFormControlInput2").val();
	var boardContents = $("#exampleFormControlTextarea1").val();
		
	//유효성 검사
	if(boardTitle == ""){
		alert("제목을 입력하시오");
	    $("#exampleFormControlInput1").focus();
	    return false;
	}
	if(boardName == ""){
		alert("작성자를 입력하시오");
	    $("#exampleFormControlInput2").focus();
	    return false;
	}
	if(boardContents == ""){
		alert("내용을 입력하시오");
	    $("#exampleFormControlTextarea1").focus();
	    return false;
	}
	
	
	console.log('유효성 검사 끝 saveAjax 호출');
	var data = {'boardTitle' : boardTitle, 'boardName' : boardName, 'boardContents' : boardContents}
	$.ajax({
		type : "POST",
		url : "/board/ajaxSave",
		data : JSON.stringify(data),
		contentType : "application/json; charset=utf-8",  //post 꼭 붙여줘야한다!~!!
		success: function(data){
			if(data == "Y"){
				alert("글 등록이 완료되었습니다.");
				$(".savview").empty();
				insertFormChk = true;
				return viewList();		
			}
		},
		error: function(data){
			alert("글등록 실패");
			console.log(data);
		}
	});
}





	




