<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> 用户登录 </title>

<style type="text/css">
h1{text-align:center;}
h4{text-align:center;color:red;}

a{text-decoration:none;font-size:20px;color:black;}
a:hover{text-decoration:underline;font-size:24px;color:red;}
</style>
</head>
<body>
<form  action="../UserLoginServlet" method="post">
	<h1>用户登陆页面</h1>
	<h4>待优化......</h4>
	<hr/>	
	<table align="center">
		<tr>
			<td>Login：</td>
			<td><input type="text" name="username" id="username"></td>
		</tr>
		<tr>
			<td>Password：</td>
			<td><input type="password" name="password" id="password"></td>
		</tr>
		
       
		<tr>
			<td colspan="1">
			</td>
			<td>
				<input type="submit" value="登陆"/>
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>