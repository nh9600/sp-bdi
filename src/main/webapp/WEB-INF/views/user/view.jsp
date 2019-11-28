<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<h1>View</h1>
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<td>${param.uiNum}</td>
			</tr>
			<tr>
				<th>이름</th>
				<td data-id="uiName"></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td data-id="uiId"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td data-id="uiPwd"></td>
			</tr>
			<tr>
				<th colspan="2">
					<button onclick="update(this)">수정</button>
					<button onclick="deleteUser(${param.uiNum})">삭제</button> <a
					href="/views/user/list"><button>리스트가기</button></a>
				</th>
			</tr>
		</table>
		<script>
			var user;
			window.onload = function() {
				var xhr = new XMLHttpRequest();
				xhr.open('GET', '/user/list/view?uiNum=${param.uiNum}');
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4) {
						if (xhr.status == 200) {
							user = JSON.parse(xhr.responseText);
							//console.log(user);
							var tds = document.querySelectorAll('td[data-id]');
							for (var idx = 0; idx < tds.length; idx++) {
								var td = tds[idx];
								var key = td.getAttribute('data-id');
								td.innerHTML = user[key];
							}

						}
					}
				}
				xhr.send();
			}
			function update(btn) {
				btn.onclick = updateUser;
				var res = document.querySelectorAll('td[data-id]');
				for (var i = 0; i < res.length; i++) {
					var td = res[i];
					var id = td.getAttribute('data-id');
					console.log(id);
					td.innerHTML = '<input type="text" id="' + id + '" value="'+ user[id]+'">';
					
				}

			}
			function updateUser() {
				var xhr = new XMLHttpRequest();
				xhr.open('PUT', '/user/list/ajax');
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4) {
						if (xhr.status == 200) {
							var res = JSON.parse(xhr.responseText);
							if (res.cnt == 1) {
								location.href = '/views/user/list';
								alert('수정 성공');
							}
						}
					}
				}
				var user = {
					uiNum : document.querySelector('#uiNum').value,
					uiName : document.querySelector('#uiName').value,
					uiId : document.querySelector('#uiId').value,
					uiPwd : document.querySelector('#uiPwd').value
				}
				xhr.send(JSON.stringify(user));
			}

			function deleteUser(a) {
				var xhr = new XMLHttpRequest();
				xhr.open('DELETE', '/user/list/ajax');
				xhr.setRequestHeader('Content-Type', 'application/json');
				xhr.onreadystatechange = function() {
					if (xhr.readyState == 4) {
						if (xhr.status == 200) {
							var res = JSON.parse(xhr.responseText);
							if (res.cnt == 1) {
								location.href = '/views/user/list';
								alert('삭제 성공');
							}
						}
					}
				}
				var user = {
						uiNum : a
				}
				console.log(user);
				xhr.send(JSON.stringify(user));
			}
		</script>
	</div>
</body>
</html>