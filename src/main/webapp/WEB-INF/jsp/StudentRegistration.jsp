<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<Form action="studentReg.do" name="Registration Form" method="post">
        <center>
            <table>
                <tr>
                    <th> Student id:</th>
                    <td> <input type="text" placeholder="studentid" name='studentid' id="studentid"></input>
                    </td>
                </tr>
                <tr>
                    <th>First Name:</th>
                    <td> <input type="text" placeholder="name" name='first_name' id="fname"></input>
                    </td>
                </tr>
                <tr>
                    <th>Last Name:</th>
                    <td> <input type="text" placeholder="name" name='last_name' id="lname"></input>
                    </td>
                </tr>
                <tr>
                    <th>Gender:</th>
                    <td> <input type="radio" name="gender" value="male" >Male</input>
                    <input type="radio" name="gender" value="female" >Female</input>
                    </td>
                </tr>
                 <tr>
                        <th> Email id:</th>
                        <td> <input type="email"  name='email'  placeholder="abcdefgh@gmail.com" id="email"></input>
                        </td>
                </tr>
                <tr>
                    <th> Password:</th>
                    <td> <input type="password" placeholder="password" name='password' id="password"  ></input>
                    </td>
                </tr>
                 <tr>
                        <th> Date Of Birth:</th>
                        <td> <input type="date"  name='dob'  id="dob"></input>
                        </td>
                </tr>
                <tr>
                    <th>City:</th>
                    <td> <input type="text"  name='city' id="city"  ></input>
                    </td>
                </tr>
                <tr>
                    <th> State:</th>
                    <td> <input type="text" name='state' id="state"  ></input>
                    </td>
                </tr>
                <tr>
                        <th> Contact no.: </th>
                        <td> <input type="text"  name='phoneno'  id="phoneno"></input>
                        </td>
                </tr>
               
                
                <tr>
                        <th colspan="2">
                        <input type="submit"  value='Make registration'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input type="reset" value='Clear'>
                        </th>
                </tr>
            </table>

        </center>
    </Form>
</body>
</html>