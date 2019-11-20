<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
	function valid(){
         var id=document.getElementById('studentid').value;
		 var first_name=document.getElementById('fname').value;
         var last_name=document.getElementById('lname').value;
         var email =document.getElementById('email').value;
         var password=document.getElementById('password').value;
         var dob=document.getElementById('dob').value;
          var city=document.getElementById('city').value;
         var state=document.getElementById('state').value;
          var contactNumber=document.getElementById('phoneno').value;
         
         var id1=document.getElementById('id1');
         var id2=document.getElementById('id2');
         var id3=document.getElementById('id3');
         var id4=document.getElementById('id4');
         var id5=document.getElementById('id5');
         var id6=document.getElementById('id6');
         var id7=document.getElementById('id7');
         var id8=document.getElementById('id8');
         var id9=document.getElementById('id9');
         
         var idregex=/^[a-zA-Z ]{4,}[0-9]{4,}$/;
         var first_nameregex=/^[a-zA-Z ]{12,}$/;
         var last_nameregex=/^[a-zA-Z ]{12,}$/;
         var emailregex=/^[a-z]{10}[0-9]{6}[@]{1}[a-z]{6}[.]{1}[a-z]{3}$/;
         var passwordregex=/^[a-zA-Z)0-9$#@]{8,}$/;
         var dobregex=/^[0-9]{2}[0-9]{2}[0-9]{4}$/;
         var cityregex=/^[a-zA-Z]{6,}$/;
         var stateregex=/^[a-zA-Z]{6,}$/;
       	 var contactNumberregex=/^[+]{1}[9]{1}[1]{1}[-]{1}[0-9]{10,10}$/;
         
         var flag=true;
         id1.innerHTML='';
         id2.innerHTML='';
         id3.innerHTML='';
         id4.innerHTML='';
         id5.innerHTML='';
         id6.innerHTML='';
         id7.innerHTML='';
         id8.innerHTML='';
         id9.innerHTML='';

         if(first_name=='')
         {
            id1.innerHTML='plz fill name';
            /* alert("Here"); */
            flag=false;

         }
         else
           if(first_nameregex.test(first_name)==false)
        {
          id1.innerHTML="name must be in alphabets";
          //location.replace()
          flag=false;

        }
         if(last_name=='')
         {
            id2.innerHTML='plz fill surname';
            flag=false;
         }
        else
         if(last_nameregex.test(last_name)==false)
        {
          id2.innerHTML="not valid";
          //location.replace()
          flag=false;

        }
         if(email=='')
         {
            id3.innerHTML='plz fill email id';
            flag=false;
         }
        else
         if(emailregex.test(email)==false)
        {
          id3.innerHTML="IMPROPER Email";
          //location.replace()
          flag=false;

        }
        //password

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
        //date of birth

        
        if(dob=='')
         {
            id5.innerHTML='plz fill DOB';
            flag=false;
         }
        else{
         var date1=new Date();
         var date2=new Date(dob);
         if(date1.getFullYear()-date2.getFullYear()<18)
         {   
          id5.innerHTML="AGE SHOULD BE 18 YEARS";
         
          //location.replace()
          flag=false;

        }
        }
        if(city=='')
        {
           id6.innerHTML='plz fill city name';
           flag=false;
        }
       else
        if(cityregex.test(city)==false)
       {
         id6.innerHTML="not valid";
         //location.replace()
         flag=false;

       }
        if(state=='')
        {
           id7.innerHTML='plz fill state name';
           flag=false;
        }
       else
        if(stateregex.test(state)==false)
       {
         id7.innerHTML="Invalid state name";
         //location.replace()
         flag=false;

       }
        //phone
        if(contactNumber=='')
         {
            id8.innerHTML='plz fill correct mobile number';
            flag=false;
         }
        else
         if(contactNumberregex.test(cont)==false)
        {
          id8.innerHTML="IMPROPER mobile number";
          //location.replace()
          flag=false;

        }
        if(id=='')
        {
           id9.innerHTML='plz fill correct id';
           flag=false;
        }
       else
        if(idregex.test(studentid)==false)
       {
         id9.innerHTML="Invalid id";
         //location.replace()
         flag=false;

       }
        if (flag) {
            document.forms['Registration Form'].submit();
        }
	}
        

    </script>
</head>
<body>
<Form action="register.do" name="Registration Form" method="post" onsubmit="return valid()">
        <center>
            <table>
                <tr>
                    <th> Student id:</th>
                    <td> <input type="text" placeholder="studentid" name='studentid' id="studentid"></input>
                    <div id='id9' class="error"></div>
                    </td>
                </tr>
                <tr>
                    <th>First Name:</th>
                    <td> <input type="text" placeholder="name" name='first_name' id="fname"></input>
                    <div id='id1' class="error"></div>
                    </td>
                </tr>
                <tr>
                    <th>Last Name:</th>
                    <td> <input type="text" placeholder="name" name='last_name' id="lname"></input>
                    <div id='id2' class="error"></div>
                    </td>
                </tr>
                <tr>
                    <th>Gender:</th>
                    <td> <input type="radio" name="gender" value="male" checked>Male</input>
                    <input type="radio" name="gender" value="female" >Female</input>
                    
                    </td>
                </tr>
                 <tr>
                        <th> Email id:</th>
                        <td> <input type="email"  name='email'  placeholder="abcdefgh@gmail.com" id="email"></input>
                        <div id='id3' class="error"></div>
                        </td>
                </tr>
                <tr>
                    <th> Password:</th>
                    <td> <input type="password" placeholder="password" name='password' id="password"  ></input>
                    <div id='id4' class="error"></div>
                    </td>
                </tr>
                 <tr>
                        <th> Date Of Birth:</th>
                        <td> <input type="date"  name='dob'  id="dob"></input>
                        <div id='id5' class="error"></div>
                        </td>
                </tr>
                <tr>
                    <th>City:</th>
                    <td> <input type="text"  name='city' id="city"  ></input>
                    <div id='id6' class="error"></div>
                    </td>
                </tr>
                <tr>
                    <th> State:</th>
                    <td> <input type="text" name='state' id="state"  ></input>
                    <div id='id7' class="error"></div>
                    </td>
                </tr>
                <tr>
                        <th> Contact no.: </th>
                        <td> <input type="text"  name='phoneno'  id="phoneno"></input>
                        <div id='id8' class="error"></div>
                        </td>
                </tr>
               
                
                <tr>
                        <th colspan="2">
                        <input type=button value=ok onclick="valid()">
                        <!-- <input type="submit"  value='Make registration'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; -->
                        <input type="reset" value='Clear'>
                        </th>
                </tr>
            </table>

        </center>
    </Form>
</body>
</html>