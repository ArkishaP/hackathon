<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adding Question..</title>
<link rel="stylesheet" href="./resources/css/admin.css">
<style type="text/css">
 .btn{
            border: 0.5px solid rgb(121, 116, 116);
            border-radius: 20px;
            width: 80%;
            height: 30px;
            color:rgb(21, 80, 207);
            /* background-color: white; */
            
        }
         button:hover{
            background-color: #ddd;
            background-color: black;
            color:rgb(253, 253, 253);

        }
        .ucontainer {
            text-align: center;
            width: 30%;
            padding: 30px;
            background-color: rgba(255, 255, 255,0.1);
            margin: auto;
            margin-top: 8%; 
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }


</style>
</head>
<body>
<div class="ucontainer">
	<h1>Upload Question Paper</h1>

	<form class="upload-form" method="POST" action="${pageContext.request.contextPath}/upload.do" enctype="multipart/form-data">
	
	<div class="form-element">
	Set Subject Id:
	<input type="text" name="subid" id="subid" placeholder="Subject Id">
	</div>
	<br>
	<div class="form-element">
	Give Subject Name:
	<input type="text" name="subname" id="subname" placeholder="Subject name">
	</div>
	<br>
	<div class="form-element">
	Set Difficulty:
	<input type="text" name="level" id="level" placeholder="Level">
	</div>
	<br>
	<div class="form-element">
	Set Duration:
	<input type="text" name="time" id="time" placeholder="Total minutes">
	<br>
	</div>
	
	<p Style="text-align: inherit;">Upload Question file:</p>	
	
	<input type="file" name="file" class="btn">
	<br>
	 <button type="submit" class="btn">Submit</button>
	<!-- <input type="submit" value="Submit"> -->
</form>
	
	<div style="font-style: italic; color: red;">${message}</div>	
	
</div>
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