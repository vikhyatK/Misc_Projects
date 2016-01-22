<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="language" value="${not empty param.language ? param.language :pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.i18n.text" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!--<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js">
	
</script>
<script type="text/javascript">
	$("document").ready(function() {
		//alert("the page just loaded");
		$("#loginform").validate({
			messages : {
				userid : "Please enter your userid",
				password : "Please enter your password",
			},
			rules : {
				userid : "required",
				password : "required",

			},

		});
	});
</script>

<style type="text/css">
label.error {
	float: none;
	color: red;
	padding-left: .5em;
	vertical-align: top;
}
</style>
--></head>
<body>
 <form>
 
            <select id="language" name="language" onchange="submit()">
               <option>Select Language</option>
                <option value="en" >English</option>
                <option value="hi" >Hindi</option>
                <option value="mr" >Marathi</option>
            </select>
        </form>
	<form name="form1" id="loginform" action="loginCheck.htm" method=post>


		<table align='center' width="100">
			<tr>
				<td colspan="2" align="center"  width="100px"><h2>Login</h2></td>
			<tr>
			<tr>
			<td><label for="username"><fmt:message key="login.label.username" />:</label></td>
				<!--<td>LoginID</td>
				--><td width="100px"><input type=text id="username" name=userid /></td>
			</tr>

			<tr>
				<!--<td>Password</td>
				--><td><label for="password"><fmt:message key="login.label.password" />:</label></td>
				<td width="100px"><input type=password id="password" name=password /></td>
			</tr>

			<tr>
				<td></td><fmt:message key="login.button.submit" var="buttonValue" />
				<td><input type='submit' name="cmd" value="${buttonValue}"  /> <input
					type='reset' value='Reset' />
			</tr>

			<tr>
				<td></td>
				<td><a href="registerpage.htm">Click here for Register</a>
				</td>
			</tr>
		</table>
	</form>

	<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</body>
</html>