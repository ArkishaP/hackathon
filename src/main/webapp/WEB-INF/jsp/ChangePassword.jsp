<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form   action="changepwd.do"	method="post">
		<table align="center">
			<tr>
				<td>Old Password: </td>
				<td><input type="password" name="opassword" id="opassword" /></td>
			</tr>
			<tr>
				<td>New Password:</td>
				<td><input type="password" name="npassword" id="npassword" /></td>
			</tr>
			<tr>
				<td>Re-type Password:</td>
				<td><input type="password" name="rpassword" id="rpassword" /></td>
			</tr>			
			<tr>
				<td></td>
				<td align="left"><input type="submit" id="login" name="Update_Password" value="Update Password"></td>
			</tr>
		</table>
	</form>
</body>
</html>