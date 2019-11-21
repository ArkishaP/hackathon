<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>

<style>
 
	.error{
		color: crimson;
	}
	</style>
<script>
	function valid(){
	var name=document.getElementById('username').value;
    var pwd=document.getElementById('password').value;
	id1.innerHTML='';
    id2.innerHTML='';
	
	if(name=='')
         {
            id1.innerHTML='plz fill name';
            flag=false;

         }
	if(pwd=='')
         {
            id2.innerHTML='plz fill PASSWORD';
            flag=false;
         }
         
	
	
	return flag;
	
	}
    </script>
</head>
<body>
<center>
<h2>Admin Login</h2>
<form class="login-form" action="login.do" method="post" onsubmit="return valid()">
            Name:
            <input type="text" placeholder="username" id="username" name="username"/>
			<div id='id1' class="error"></div>
			Pasword:
            <input type="password" placeholder="password" id="password" name="password"/>
			<div id='id2' class="error"></div>
			<br>
			<input type="submit" value='Login'>


</center>
</body>
</html>