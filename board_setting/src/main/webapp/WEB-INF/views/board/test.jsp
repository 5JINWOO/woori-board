<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>
<%@ include file="../common/nav.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST</title>
<script>
	function Gugudan() {
		console.log('Gugudan 실행');
		var guguSel = document.getElementById("guguSel").value;

		var result = "";

		if (guguSel != "") {
			for (var i = 1; i <= 9; i++) {
				result += guguSel + " × " + i + " = " + (guguSel * i) + "<br>";
			}
			$("#guguView").html(result);
		} else {
			alert("숫자를 선택하세요");
		}
	}

	function Chgcolor() {
		console.log('Chgcolor 실행');
		arr1 = ['all', '1', '2', '3', '4'];
		arr2 = ['red', 'blue', 'yellow', 'green'];
		
		 var orderSel = $('#orderSel option:selected').val();		 
		 var colorSel = $('#colorSel option:selected').val();

		 

/* 		 var colorResult = [[orderSel,colorSel]];
		 console.log($(colorResult);

		 $('select[name=selectedBox] option:selected').each(function(index){

			 var num=$(this).attr('value');

			 valueArray.push(num);
			});		 */
	}

		 

/* 		 switch(order) {
		 case "all": if(color == "red"){$("allDiv > div").css("color", "#ff0000" );} 
	 		else if(color == "blue"){$("allDiv > div").css("color", "#0000ff" );}
	 		else if(color == "yellow"){$("allDiv > div").css("color", "#ffff00" );}
	 		else (color == "green"){$("allDiv > div").css("color", "#008000" );}
	 		break;

		 case "first":if(color == "red"){ $("firstDiv").css("color", "#ff0000" );} 
	 		else if(color == "blue"){$("firstDiv").css("color", "#0000ff" );}
	 		else if(color == "yellow"){$("firstDiv").css("color", "#ffff00" );}
	 		else (color == "green"){$("firstDiv").css("color", "#008000" );}
	 		break;

		 case "second":if(color == "red"){ $("secondDiv").css("color", "#ff0000" );} 
	 		else if(color == "blue"){$("secondDiv").css("color", "#0000ff" );}
	 		else if(color == "yellow"){$("secondDiv").css("color", "#ffff00" );}
	 		else (color == "green"){$("secondDiv").css("color", "#008000" );}
	 		break;

		 case "third":

		 case "fourth":
		 } */

</script>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<form>
					<h2>TEST2- 구구단</h2>  <!-- 구구단 test -->
					<select id="guguSel">
						<option value="" selected disabled>선택</option>
						<option value="2">2단</option>
						<option value="3">3단</option>
						<option value="4">4단</option>
						<option value="5">5단</option>
						<option value="6">6단</option>
						<option value="7">7단</option>
						<option value="8">8단</option>
						<option value="9">9단</option>
					</select> 
					<input type="button" value="계산" onclick="Gugudan()">
					<div id="guguView"></div>
				</form>
			</div>
			
			<div class="col-sm-6 allDiv" >  <!-- 색상 변경 test -->
				<form>
				<h2>TEST4- 색상변경</h2>
				<div id="firstDiv">첫번째</div>
				<div id="secondtDiv">두번째</div>
				<div id="thirdtDiv">세번째</div>
				<div id="fourthDiv">네번째</div>
				
					<select id="orderSel">
						<option value="" selected>선택</option>
						<option value="all">전체</option>
						<option value="1">첫번째</option>
						<option value="2">두번쨰</option>
						<option value="3">세번쨰</option>
						<option value="4">네번쨰</option>
					</select>
					<select id="colorSel">
						<option value="" selected>선택</option>
						<option value="red">빨강</option>
						<option value="blue">파랑</option>
						<option value="yellow">노랑</option>
						<option value="green">초록</option>
					</select>
					 <input type="button" value="변경" onclick="Chgcolor()">
				</form>
			</div>
		</div>
	</div>
</body>
</html>