<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Spring MVC file upload example</h1>

<form method="POST" action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data">
    <div>
        <label>Subject Id:</label>
        <input type="text" name="subjectId" id="subjectId">
    </div>
    <div>
        <label>Subject Name:</label>
        <input type="text" name="subjectName" id="subjectName">
    </div>
    <div>
        <label>Difficulty:</label>
        <input type="text" name="difficulty" id="difficulty">
    </div>
    <div>
        <label>Subject Id:</label>
        <input type="text" name="subjectId" id="subjectId">
    </div>
    <input type="file" name="file" /><br/>
    <input type="submit" value="Submit" />
</form>

<h1>Upload Status</h1>
<h2>Message : ${message}</h2>
</body>
</html>