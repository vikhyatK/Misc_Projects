<%@page import="com.mvc.bean.Pets"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.i18n.text" />
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pets Owned</title>
</head>
<body>
	<h3 align="center"><fmt:message key="pet.viewall.header" /></h3>
	<table align="center">
		<tr>
			<th><fmt:message key="pet.viewall.label.pet_id" /></th>
			<th><fmt:message key="pet.viewall.label.pet_name" /></th>
			<th><fmt:message key="pet.viewall.label.pet_type" /></th>
			<th><fmt:message key="pet.viewall.label.birth_date" /></th>
		</tr>

		<c:forEach var="al" items="${pet_details }">
			<tr>
				<td><c:out value="${al.pet_id }" />
				</td>
				<td><c:out value="${al.pet_name }" />
				</td>
				<td><c:out value="${al.type }" />
				</td>
				<td><c:out value="${al.birth_date }" />
				</td>
			</tr>
		</c:forEach>


	</table>
	
	<% ArrayList<Pets> pets_list = (ArrayList<Pets>)request.getAttribute("pet_details");
		int owner_id = pets_list.get(0).getOwner_id();
		pageContext.setAttribute("id", owner_id);
	%>
	
	<table align="center">
		<tr>
			<td><form action="get_owner.htm" method="post">
					<input type="hidden" name="searchType" value="Id" />
					<input type="hidden" name="own_id" value="${id }" />
					<fmt:message key="pet.viewall.button.back" var="buttonValue" />
					<input type="submit" name="cmd" value="${buttonValue}" />
				</form>
			</td>
			<td><form action="addMore_Pets.htm" method="post">
					<input type="hidden" name="own_id" value="${id }" />
					<fmt:message key="pet.viewall.button.add_pets" var="buttonValue" />
					<input type="submit" name="cmd" value="${buttonValue}" />
				</form>
			</td>
			<td><form action="search_owners.htm" method="post">
					<fmt:message key="pet.viewall.button.search" var="buttonValue" />
					<input type="submit" value="${buttonValue}" />
				</form>
			</td> 
		</tr>
	</table>
</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>