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
		<table class="table table-bordered">
			<h1>Sign-up</h1>
			<tr>
				<th>이름</th>
				<td><input type="text" id="uiName"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" id="uiId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" id="uiPwd"></td>
			</tr>
			<tr>
				<th colspan="2"><button onclick="save()">저장</button></th>
		</table>
	</div>
	<script>
		function save() {
			var xhr = new XMLHttpRequest();
			xhr.open('POST', '/user/list/signup');
			xhr.setRequestHeader('Content-Type', 'application/json');
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						var res = JSON.parse(xhr.responseText);
						if(res.cnt==1){
							location.href = '/views/user/list';
							alert('성공');
						}
					}
				}
			}
			var user = {
					uiName:document.querySelector('#uiName').value,
					uiId:document.querySelector('#uiId').value,
					uiPwd:document.querySelector('#uiPwd').value
			}
			xhr.send(JSON.stringify(user));
		}
	</script>
</body>
</html>