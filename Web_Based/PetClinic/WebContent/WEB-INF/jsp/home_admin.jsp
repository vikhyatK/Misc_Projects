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

<title>Admin Home Page</title>

</head>

<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	${username}
	<div align="right">
		<form action="logout.htm">
			<fmt:message key="admin.button.logout" var="buttonValue" />
			<input type="button" id="logout" value="${buttonValue}"
				onclick="submit()" />
		</form>
	</div>
	<table align="center">
		<tr>
			<td colspan="2" align="center"><h2>
					<fmt:message key="admin.label.header" />
				</h2></td>
		</tr>

		<tr>
			<td></td>
		</tr>

		<tr>
			<td><a href="add_Owner.htm"><fmt:message
						key="admin.label.owner" /></a></td>
		</tr>

		<tr>
			<td><a href="add_Pet.htm"><fmt:message key="admin.label.pet" /></a></td>
		</tr>

		<tr>
			<td><a href="add_Vet.htm"><fmt:message key="admin.label.vet" /></a></td>
		</tr>

		<tr>
			<td><a href="search_owners.htm"> <fmt:message
						key="admin.label.search_owner" /></a></td>
		</tr>

		<tr>
			<td><a href="pet_id.htm"> <fmt:message
						key="admin.label.appointment" />
			</a></td>
		</tr>

	</table>

</body>

</html>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>