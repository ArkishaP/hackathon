<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
.error{
    color: crimson;
}

    </style>

<script>
                function valid(){
                	
				var studentid=document.getElementById('studentid').value;
				var password=document.getElementById('password').value;

				var id1=document.getElementById('id1');
				var id2=document.getElementById('id2');
				
				var sidregex=/^[A-Za-z]{4,}[0-9]{2,}$/;
				var passwordregex=/^[a-zA-Z)0-9$#@]{8,}$/;
				
				
				var flag=true;
				id1.innerHTML='';
				id2.innerHTML='';
				
				 if(studentid=='')
		         {
		            id1.innerHTML='plz fill Id';
		            flag=false;
		         }
		        else
		         if(sidregex.test(studentid)==false)
		        {
		          id1.innerHTML="IMPROPER Id";
		          //location.replace()
		          flag=false;

		        }
				 if(password=='')
			        {
			           id2.innerHTML='plz fill password';
			           flag=false;
			        }
			       else
			        if(passwordregex.test(password)==false)
			       {
			         id2.innerHTML="Invalid Password";
			         //location.replace()
			         flag=false;

			       }
				 return flag;
                }
    </script>
</head>
<body>
<Form action="login.do"  name="Login Form" method="post" onsubmit="return valid()">
        <center>
            <table>
                <tr>
                    <th> Student id:</th>
                    <td> <input type="text" placeholder="studentid" name='studentid' id="studentid" ></input>
                    <div id='id1' class="error"></div>
                    </td>
                </tr>
                
                <tr>
                    <th> Password:</th>
                    <td> <input type="password" placeholder="password" name='password' id="password"  ></input>
                    <div id='id2' class="error"></div>
                    </td>
                </tr>
                
                <tr>
                        <th colspan="2">
                         <input type="submit" value="Login" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value='Clear'>
                        </th>
                </tr>
                <tr>
				<td></td>
				<td><a href="forgetpassword.do">forget password ?</a></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="register.do">Register Now !!</a></td>
			</tr>
                 </table>

        </center>
    </Form>
</body>
</html>