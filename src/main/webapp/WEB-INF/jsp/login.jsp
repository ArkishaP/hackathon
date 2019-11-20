<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>

<script>
                function valid(){
				var id=document.getElementById('studentId').value;
				var password=document.getElementById('password').value;

				var id4=document.getElementById('id4');
				var id9=document.getElementById('id9');
				
				
				var passwordregex=/^[a-zA-Z)0-9$#@]{8,}$/;
				var idregex=/^[a-zA-Z ]{4,}[0-9]{4,}$/;
				
				var flag=true;
				id4.innerHTML='';
				id9.innerHTML='';
				
				 if(password=='')
		         {
		            id4.innerHTML='plz fill PASSWORD';
		            flag=false;
		         }
		        else
		         if(passwordregex.test(password)==false)
		        {
		          id4.innerHTML="IMPROPER PASSWORD";
		          //location.replace()
		          flag=false;

		        }
				 if(id=='')
			        {
			           id9.innerHTML='plz fill correct id';
			           flag=false;
			        }
			       else
			        if(idregex.test(studentId)==false)
			       {
			         id9.innerHTML="Invalid id";
			         //location.replace()
			         flag=false;

			       }

    </script>
</head>
<body>
<Form action="login.do"  name="Login Form" method="post">
        <center>
            <table>
                <tr>
                    <th> Student id:</th>
                    <td> <input type="text" placeholder="studentid" name='studentid' id="studentid"></input>
                    </td>
                </tr>
                
                <tr>
                    <th> Password:</th>
                    <td> <input type="password" placeholder="password" name='password' id="password"  ></input>
                    </td>
                </tr>
                <tr>
                        <th colspan="2">
                        <input type="submit"  value='Make Login'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value='Clear'>
                        </th>
                </tr>
                 </table>

        </center>
    </Form>
</body>
</html>