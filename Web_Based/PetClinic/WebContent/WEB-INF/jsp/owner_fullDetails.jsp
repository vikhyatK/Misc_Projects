<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.i18n.text" />
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Owner Details</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#back").click(function() {
			window.location = "search_owners.htm";
		});

	});
</script>
</head>
<body>

	<h3 align="center">
		${own_details.own_fname }
		<fmt:message key="owner.details.header" />
	</h3>
	<table align="center">

		<tr>
			<td><label for="owner id"><fmt:message
						key="owner.details.label.own_id" /></label></td>
			<td>${own_details.own_id }</td>
		</tr>

		<tr>
			<td><label for="owner fname"><fmt:message
						key="owner.details.label.own_fname" /></label></td>
			<td>${own_details.own_fname }</td>
		</tr>

		<tr>
			<td><label for="owner lname"><fmt:message
						key="owner.details.label.own_lname" /></label></td>
			<td>${own_details.own_lname }</td>
		</tr>

		<tr>
			<td><label for="address"><fmt:message
						key="owner.details.label.address" /></label></td>
			<td>${own_details.address }</td>
		</tr>

		<tr>
			<td><label for="telephone"><fmt:message
						key="owner.details.label.telephone" /></label></td>
			<td>${own_details.telephone }</td>
		</tr>
		<tr>
			<td><fmt:message key="owner.register.button.back"
					var="buttonValue" /> <input type="button" id="back"
				value="${buttonValue}" /></td>
		</tr>
	</table>

</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>