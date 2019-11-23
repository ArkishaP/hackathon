<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="./resources/css/admin.css"> 
 
<title>Admin Login</title>

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
        .form-element input {
            display: block;
            width: 80%;
            height: 30px;
            margin: auto;
            padding: 15px;
            background-color: rgb(235, 232, 232);
            border-radius: 20px;
        }
       
       .form-element input:focus{
       		outline:none;
       }


</style>



</head>
<body>
    <div class="lcontainer">
        <h2>Admin Login</h2>
        
            <form class="login-form" action="adminLogin.do" method="post" >
                <div class="form-element">
                    <!-- <label>Username</label> -->
                    <input type="text" placeholder="Username" id="username" name="username" />
                    <div id='id1' class="error"></div>
                </div>
                <br>
                <div class="form-element">
                    <!-- <label>Password</label> -->
                    <input type="password" placeholder="Password" id="password" name="password" />
                    <div id='id2' class="error"></div>
                </div>
                <br>
                <br>
                <button type="submit" class="btn">Login</button>
                <br>
                
            </form>
            <br>
        <div style="font-style: italic; color: red;">${message}</div>
    </div>
</body>

</html>