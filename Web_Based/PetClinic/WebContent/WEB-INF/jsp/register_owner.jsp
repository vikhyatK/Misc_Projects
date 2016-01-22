<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.i18n.text" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Owner Registration</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js">
	
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#registerform").validate({

			rules : {
				own_fname : "required",
				own_lname : "required",
				telephone : "required"
			},

			messages : {

				own_fname : "Please enter owner's firstname",
				own_lname : "Please enter owner's lastname",
				telephone : "Please enter owner's telephone number"

			}

		});

		$("#back").click(function() {
			window.location = "back.htm";
		});
	});
</script>
<style type="text/css">
label.error {
	float: none;
	color: red;
	padding-right: .5em;
	vertical-align: top;
}
</style>

</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<form id="registerform" action="register_owner.htm" method="post">

		<table align="center">
			<tr>
				<td colspan="2" align="center"><h2>
						<fmt:message key="owner.register.header" />
					</h2></td>
			<tr>
			<tr>
				<td><label for="firstname"><fmt:message
							key="owner.register.label.own_fname" /></label></td>
				<td><input type="text" name="own_fname" /></td>
			</tr>

			<tr>
				<td><label for="lastname"><fmt:message
							key="owner.register.label.own_lname" /></label></td>
				<td><input type="text" name="own_lname" /></td>
			</tr>

			<tr>
				<td><label for="address"><fmt:message
							key="owner.register.label.address" /></label></td>
				<td><input type="text" name="address" /></td>
			</tr>

			<tr>

				<td><label for="telephone"><fmt:message
							key="owner.register.label.telephone" /></label></td>
				<td><input type="text" name="telephone" /></td>
			</tr>

			<tr>
				<td></td>
				<fmt:message key="owner.register.button.submit" var="buttonValue" />
				<td><input type="submit" value="${buttonValue}" /> <fmt:message
						key="owner.register.button.reset" var="buttonValue" /> <input
					type="reset" value="${buttonValue}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><fmt:message key="owner.register.button.back"
						var="buttonValue" /> <input type="button" id="back"
					value="${buttonValue}" /></td>
			</tr>
		</table>
	</form>
</body>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</html>