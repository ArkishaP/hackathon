<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%=session.getAttribute("subject") %>
<hr>
${question }

<a href="">Finish Exam</a>
<%-- ${subject }
${student }<br>
${exam }<br>
${questions }
<hr>
<form method="POST">
<c:forEach items="${questions }" var="qrecord">
<div>
	<label>${qrecord.question}</label>
	<input type="radio" name="option" value="${qrecord.option1 }">${qrecord.option2 }
	<input type="radio" name="option" value="${qrecord.option2 }">${qrecord.option2 }
	<input type="radio" name="option" value="${qrecord.option3 }">${qrecord.option3 }
	<input type="radio" name="option" value="${qrecord.option4 }">${qrecord.option4 }
	<input type="submit" value="answer">
</c:forEach>
</div>
</form> --%>
</body>
</html>