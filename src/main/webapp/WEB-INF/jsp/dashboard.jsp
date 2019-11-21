<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./resources/css/exam.css">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div><h1>Select exam</h1></div>
    <div class="grid-container">
    	<c:forEach items="${subjects}" var="subject">
		<a href="exam.do?subject=${subject}">
        	<div class="grid-item">
            	<h2>${subject}</h2>
            </div>
		</a>
		</c:forEach>
	</div>
</div>
</body>
</html>