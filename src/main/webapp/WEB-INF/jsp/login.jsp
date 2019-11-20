<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<Form action="loginUser.do" name="Login Form" method="post">
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