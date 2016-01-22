<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language :pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.i18n.text" />
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form>
 
            <select id="language" name="language" onchange="submit()">
               <option>Select Language</option>
                <option value="en" >English</option>
                <option value="hi" >Hindi</option>
                <option value="mr" >Marathi</option>
            </select>
        </form><!--
        <form>
            <select id="language1" name="language1" ">
                <option value="en" >English</option>
                <option value="nl" >Nederlands</option>
                <option value="es" >Español</option>
            </select>
        </form>
	--><form name="form1" action="loginCheck.htm" method=post>

		<table align='center'>
			<tr>
				<td colspan="2" align="center"><h2>LOGIN</h2>
				</td>
			<tr>
			<tr> 
				<td><label for="username"><fmt:message key="login.label.username" />:</label></td>
				<td><input type=text id="username" name=userid />
				</td>
			</tr>
 
            
			<tr>
				<td><label for="password"><fmt:message key="login.label.password" />:</label></td>
				<td><input type=text id="password" name=password />
				</td>
			</tr>

			<tr>
				<td></td><fmt:message key="login.button.submit" var="buttonValue" />
				<td><input type='submit' name="cmd" value="${buttonValue}" /> 
				<input type='reset' value='Reset' /> 
			</tr>
			
			<tr>
			<td></td>
			<td><a href="registerpage.htm">Register Yourself</a></td>
			</tr>
		</table>
	</form>


</body>
</html>