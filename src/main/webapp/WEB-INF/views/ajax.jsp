<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button>GET</button>
	<button>POST JSON</button>
	<button>POST Param</button>
	<script>
		var ajax = function(conf) {
			var xhr = new XMLHttpRequest();
			xhr.open(conf.method, conf.url);
			if(conf.method=='POST'){
				xhr.setRequestHeader('Content-Type','application/json');
			}
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4) {
					if (xhr.status == 200) {
						conf.callback(xhr.responseText);
					}
				}
			}
			xhr.send(conf.data);
		}
		window.onload = function() {
			var btns = document.querySelectorAll('button');
			for (var i = 0; i < btns.length; i++) {
				var btn = btns[i];
				if (btn.innerText == 'GET') {
					btn.onclick = function() {
						ajax({
							method : 'GET',
							url : '/ajax?a=1&b=2',
							callback : function(res) {
								res = JSON.parse(res);
								alert(res.greeting);
							}
						});
					}
				} else if (btn.innerText == 'POST JSON') {
					btn.onclick = function() {
						var param = {
								a:1,
								b:2
						}
						ajax({
							method : 'POST',
							url : '/ajax/json',
							callback : function(res) {
								res = JSON.parse(res);
								alert(res.greeting);
							},
							data : JSON.stringify(param)
						});
					}
				} else {
					btn.onclick = function() {
						var fd = new FormData();
						fd.append('a', 1);
						fd.append('b', 2);
						ajax({
							method : 'POST',
							url : '/ajax',
							callback : function(res) {
								res = JSON.parse(res);
								alert(res.greeting);
							},
							data : fd
						});
					}
				}
			}
		}
	</script>
</body>
</html>