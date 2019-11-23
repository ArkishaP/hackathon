<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%-- The exam is for ${exam} --%>
${subject.difficulty }
The exam will be of ${subject.duration } minutes.
${subject.subjectId }
<a href="exam.do?subject=${subject.subjectName }&question=${subject.questions[0].questionId}">Start Exam</a>
</body>
</html>