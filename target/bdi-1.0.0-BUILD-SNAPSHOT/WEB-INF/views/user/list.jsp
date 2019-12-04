<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="/res/bt/js/jquery-3.4.1.js"></script>
<script src="/res/bt/js/bootstrap.min.js"></script>
<script src="/res/bt/js/bootstrap.bundle.js"></script>
<link rel="stylesheet" href="/res/bt/css/bootstrap.css" />
<link rel="stylesheet" href="/res/bt/css/bootstrap-reboot.css" />
<link rel="stylesheet" href="/res/bt/css/bootstrap-grid.css" />
</head>
<body>
	<div class="container">
		<H1>User List</H1>
		<div class="search"> <label for="uiName">이름</label> <input
			type="checkbox" name="search" value="ui_name" id="uiName"> </div>
		<label for="uiId">ID</label> <input type="checkbox" name="search"
			value="ui_id" id="uiId"> <label for="uiNum">번호</label> <input
			type="checkbox" name="search" value="ui_num" id="uiNum"> <input
			type="text" id="searchStr">
		<button>검색</button>
		</div>
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>생성일</th>
				<th>생성시간</th>
			</tr>
			<tbody id="tBody"></tbody>
		</table>
		<a href="/views/user/signup"><button>회원가입</button></a>
	</div>
	<script>
	function getUserList(param){
		var xhr = new XMLHttpRequest();
		xhr.open('GET', '/user/list/ajax?'+param);
		xhr.setRequestHeader('Content-Type','application/json');
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4) {
				if (xhr.status == 200) {
					var list = JSON.parse(xhr.responseText);
					var html = '';
					for(var user of list){
						html+='<tr>';
						html+='<td><a href="/views/user/view?uiNum='+ user.uiNum + '">'+user.uiNum+'</a></td>';
						html+='<td>'+user.uiName+'</td>';
						html+='<td>'+user.uiId+'</td>';
						html+='<td>'+user.uiPwd+'</td>';
						html+='<td>'+user.credat+'</td>';
						html+='<td>'+user.cretim+'</td>';
						html+='</tr>';
					}
                     document.querySelector('#tBody').innerHTML = html;
				}
			}
		}
		xhr.send();
	}
		window.onload = function() {
			getUserList('');
			var btn = document.querySelector('button');
			btn.onclick = function(){
				var checks = document.querySelectorAll('[name=search]:checked');
				if(checks.length==0){
					alert('검색대상을 1개라도 선택하셈');
					return;
				}
				var searchStr = document.querySelector('#searchStr');
				if(searchStr.value.trim().length<1){
					alert('검색어를 입력해주세요.');
					return;
			}
				
				var search = '';
				for(var i=0;i<checks.length;i++){
					search += 'search=' + checks[i].value +'&';
				}
				search += 'searchStr=' + searchStr.value;
				getUserList(search);
			}
		  }
		
	</script>
</body>
</html>