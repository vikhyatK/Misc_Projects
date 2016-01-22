<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<script>
   

    function validate()
    {
        if((document.frmLogin.sUserName.value)=="")
        {
          alert("Login empty");
          document.frmLogin.sUserName.focus();
          return false;
        }
        else if((document.frmLogin.sPwd.value)=="")
        {
          alert("password empty");
          document.frmLogin.sPwd.focus();
          return false;
        }
    }
</script>

</head>
<body>
	<b>Hello ${userid}</b>
	<br />you have Registered yourself successfully..!!!
	<form action="loginCheck.htm" id="login" method=post>
		Username: <input type=text name=userid><br> Password: <input
			type=password name=password><br> <input type=submit
			value="Login" />
	</form>
</body>
</html>
