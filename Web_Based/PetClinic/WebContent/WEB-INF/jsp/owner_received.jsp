
<%@page import="com.mvc.bean.Owners"%>
<%@page import="java.util.ArrayList"%>
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
<title>Owners</title>
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
	<table align="center">
		<tr>
			<td colspan="2" align="center"><h2>
					<fmt:message key="owner.received.header" />
				</h2></td>
		<tr>
		<tr></tr>
		<tr></tr>
		<c:forEach var="owners" items="${own_details }">

			<tr>
				<td><label for="owner Id"><fmt:message
							key="owner.received.label.own_id" /></label></td>
				<td>${owners.own_id }</td>
			</tr>
			<tr>
				<td><label for="owner name"><fmt:message
							key="owner.received.label.own_name" /></label></td>
				<td>${owners.own_fname } ${owners.own_lname }</td>
			</tr>
			<tr>
				<td><form action="own_fulldetails.htm" method="post">
						<input type="hidden" name="own_fname" value="${owners.own_fname }" />
						<input type="hidden" name="search_Type" value="SearchDone" />
						<fmt:message key="owner.received.button.submit" var="buttonValue" />
						<input type="submit" value="${buttonValue}" />
					</form></td>
				<td><fmt:message key="owner.register.button.back"
						var="buttonValue" /> <input type="button" id="back"
					value="${buttonValue}" /></td>
			</tr>
			<tr></tr>
		</c:forEach>
		<tr></tr>

	</table>

</body>
</html>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>