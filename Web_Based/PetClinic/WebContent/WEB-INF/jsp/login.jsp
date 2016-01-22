<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>
<c:set var="language"
	value="${not empty param.language ? param.language : pageContext.request.locale}"
	scope="session" />

<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.i18n.text" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>Pet Controller</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>

<script type="text/javascript"
	src="./jquery.i18n.properties-min-1.0.9.js"></script>

<script type="text/javascript"
	src="/<web-context-root>/js/jquery.i18n.properties-min-1.0.9.js"></script>
<%-- 
<script>
	$(document).ready(function() {

		jQuery.i18n.properties({

			name : 'text',
			path : 'com/example/i18n/',
			mode : 'both',
			language : '${language}',
			callback : function() {

				$("#loginform").validate({

					messages : {

						username : $.i18n.prop('login.error.username'),
						password : $.i18n.prop('login.error.password')

					},

					rules : {

						username : "required",
						password : "required"

					}
				});

			}

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
</style> --%>

<script type="text/javascript">
	$(document).ready(function() {

		$("#loginform").validate({
			messages : {

				username : "Please enter username",
				password : "Please enter password"
			},
			rules : {
				username : "required",
				password : "required"
			}
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
</head>

<body>

	<form>
		<%@ include file="/WEB-INF/jsp/header1.jsp"%>
		<label for="select"> <fmt:message
				key="login.label.select_lang" />
		</label> <select id="language" name="language" onchange="submit()">
			<option>
				<fmt:message key="login.label.select_lang" />
			</option>
			<option value="en" ${language=='en' ? 'selected' : ''}>English</option>
			<option value="hi" ${language=='hi' ? 'selected' : ''}>हिंदी</option>
		</select>

	</form>

	<form id="loginform" action="loginCheck.htm" method=post>

		<table align='center'>

			<tr>
				<td></td>
				<td colspan="2" align="center"><b><fmt:message
							key="login.button.submit" /></b></td>
			<tr>
			<tr>

				<td><label for="username"> <fmt:message
							key="login.label.username" />
				</label></td>
				<td><input type=text name=username /></td>
			</tr>

			<tr>
				<td><label for="password"><fmt:message
							key="login.label.password" /></label></td>
				<td><input type=password name=password /></td>
			</tr>

			<tr>
				<td></td>
				<td>${error}<%
					request.getSession().removeAttribute("error");
				%></td>
			</tr>

			<tr>
				<td></td>
				<td><fmt:message key="login.button.submit" var="buttonValue" />
					<input type="submit" name="cmd" value="${buttonValue}" /> <fmt:message
						key="login.button.reset" var="buttonValue" /> <input type="reset"
					value="${buttonValue}" /></td>

			</tr>
		</table>
	</form>

</body>

</html>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>