<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.mvc.bean.Pets"%>
<%@page import="java.util.ArrayList"%>
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
<title>Pet Details</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		$("#back").click(function() {
			window.location = "pet_id.htm";
		});
	});
</script>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<form action="appointment.htm" method="post">
		<table align='center'>
			<tr>
				<td colspan="2" align="center"><h2>
						<fmt:message key="pet.details.header" />
					</h2></td>
			<tr>
			<tr></tr>
			<tr></tr>

			<tr>
				<td><label for="pet Id"><fmt:message
							key="pet.details.label.pet_id" /></label></td>
				<td>${pet_details.pet_id }</td>
			</tr>
			<tr>
				<td><label for="pet name"><fmt:message
							key="pet.details.label.pet_name" /></label></td>
				<td>${pet_details.pet_name }</td>
			</tr>
			<tr>
				<td><label for="pet type"><fmt:message
							key="pet.details.label.pet_type" /></label></td>
				<td>${pet_details.type}</td>
			</tr>
			<tr>
				<td><label for="birth_date"><fmt:message
							key="pet.details.label.birth_date" /></label></td>
				<td>${pet_details.birth_date }</td>
			</tr>
			<tr>
				<td><label for="owner_id"><fmt:message
							key="pet.details.label.owner_id" /></label></td>
				<td>${pet_details.owner_id }</td>
			</tr>

			<tr>
				<td><input type="hidden" name="pet_Id"
					value="${pet_details.pet_id }" /> <fmt:message
						key="pet.details.button.submit" var="buttonValue" /> <input
					type="submit" value="${buttonValue}" /></td>
				<td><fmt:message key="owner.register.button.back"
						var="buttonValue" /> <input type="button" id="back"
					value="${buttonValue}" /></td>
			</tr>
			<tr></tr>
			<tr></tr>

		</table>
	</form>


</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>