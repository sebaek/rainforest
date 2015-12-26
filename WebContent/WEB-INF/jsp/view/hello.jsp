<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/page.css">
<link rel="stylesheet" href="/resources/css/AXJ.min.css">
<link rel="stylesheet" href="/resources/css/AXInput.css">
<link rel="stylesheet" href="/resources/css/AXSearch.css">
<link rel="stylesheet" href="/resources/css/AXSelect.css">

<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/AXJ.min.js"></script>
<script type="text/javascript	" src="/resources/js/AXInput.js"></script>
<script type="text/javascript" src="/resources/js/AXSelect.js"></script>
<script type="text/javascript" src="/resources/js/AXSearch.js"></script>

<style type="text/css">
div.container {
	text-align: center;
}
</style>

<script type="text/javascript">
var pageID = "Default";
var fnObj = {
	pageStart: function(){

		$(".AXInputSearch").bindSearch();
		$(".AXInputPlaceHolder").bindPlaceHolder();

		$('input[type=checkbox]').bindChecked();
		$('input[type=radio]').bindChecked();	
	}
};
jQuery(document.body).ready(function(){fnObj.pageStart()});

$(document).ready(function(){
	
	$('#div-wait').hide();
	$('#div-success').hide();
	
	$('#submit').on('click', function(){
		var _data = $('form').serialize();
		$.ajax({
            url:'/match',
            type:'post',
            data:_data,
            async: true,
//             complete: function(){
            beforeSend: function(){
            	$('#div-form').hide();
            	$('#span-wait').text('상대를 찾고 있습니다.')
            	$('#div-wait').show();
           	},
            success:function(data){
            	$('#div-wait').hide();
//             	$('#span-success').text(JSON.stringify(data));
// 				var txt = '';
// 				var txt = JSON.parse(data.User);
// 				var txt = JSON.parse(data);
				debugger;
// 				var txt = data;
				var tmpData = JSON.parse(data);
				var txt = '|| 상대방이 연결되었습니다 ||<br /><br /><br /><br />';
				for (key in tmpData) {
					txt += key + ' : ' + tmpData[key] + '<br />';
				}
// 				"User [isMatched=true, seq=5, matchedSeq=6, isOut=false, nickName=a, gender=2, hobby=zzz, city=01]"
            	
//             	$('#span-success').text(txt);
            	$('#span-success').html(txt);
            	$('#div-success').show();
            }
        })
	});
})

var fn = {
	toggle: function(target){
// 		$(target).show();
// 		$(target).hide();
	}
}

</script>

</head>
<body>
<div class="wrap">
	<div class="content">
		<div class="container">
		
			<div id="div-form">
			
				<form action="">
				
				<div class="H20"></div>
				<h1>상대방 찾기</h1>
				<div class="H20"></div>
			
				<div class="H10"></div>
				<label>이름</label>
				<input type="text" name="nickName" value="john" class="AXInput">
				
				<div class="H10"></div>
				<label>취미</label>
				<input type="text" name="hobby" value="sleep" class="AXInput">
				
				<div class="H10"></div>
				<label>지역</label>
				<select name="city">
					<option value="01">서울특별시</option>
					<option value="02">부산광역시</option>
					<option value="03">인천광역시</option>
					<option value="04">대구광역시</option>
					<option value="05">대전광역시</option>
					<option value="06">광주광역시</option>
				</select>
				<div class="H10"></div>
	
				<div>
					<label>
						<input type="radio" checked name="gender" value="1" id="axchecked-6" data-axbind="checked" style="opacity: 0;"><div id="inputBasic_AX_axchecked-6" class="AXanchor" style="left: 0px; top: 127.266px; width: 13px; height: 0px; display: block;"><div id="inputBasic_AX_axchecked-6_AX_HandleContainer" class="AXbindCheckedHandle_radio" style="left:2px;top:0px;width:20px;height:20px;" onselectstart="return false;"><a class="checked-icon"></a></div></div>
						남성
					</label>
					<label>
						<input type="radio" name="gender" value="2" id="axchecked-7" data-axbind="checked" style="opacity: 0;"><div id="inputBasic_AX_axchecked-7" class="AXanchor" style="left: 93.3594px; top: 127.266px; width: 13px; height: 0px; display: block;"><div id="inputBasic_AX_axchecked-7_AX_HandleContainer" class="AXbindCheckedHandle_radio checked" style="left:2px;top:0px;width:20px;height:20px;" onselectstart="return false;"><a class="checked-icon"></a></div></div>
						여성
					</label>
				</div>
				
				</form>
				
				<div class="H10"></div>
	            <button type="button" id="submit">연결</button>
			</div>
			
			<div id="div-wait">
				<span id="span-wait"></span>
			</div>
			
			<div id="div-success">
				<span id="span-success"></span>
			</div>
		
		</div>
	</div>
</div>
</body>
</html>