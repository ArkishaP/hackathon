<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Upload Question Paper</h1>
<form method="POST" action="test.do">
	<input type="text" name="name">
	<input type="submit" value="ok">
</form>
<form method="POST" action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data">
	
	Set Subject Id:
	<input type="text" name="subid" id="subid" placeholder="Subject Id"><br>
	Give Subject Name:
	<input type="text" name="subname" id="subname" placeholder="Subject name"><br>
	Set Difficulty:
	<input type="text" name="level" id="level" placeholder="Level"><br>
	Set Duration:
	<input type="text" name="time" id="time" placeholder="Total minutes"><br>
	Upload your Question file here:<br>
	<input type="file" name="file"><br>
	<input type="submit" value="Submit">
</form>
	<h3>Details on Subject:</h3>
	<h3>Message : ${message}</h3>	
	<hr>
	<%-- <form method="POST" action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data">
	Upload your Question file here:<br>
	<input type="file" name="file"><br>
    <input type="submit" value="Submit">
</form> --%>
<%-- 
<h3>Upload Status</h3>
<h3>Message : ${message}</h3> --%>
</body>
</html>