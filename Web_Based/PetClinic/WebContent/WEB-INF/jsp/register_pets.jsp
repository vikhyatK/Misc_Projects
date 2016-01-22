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
<title>Pet Registration</title>
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
<link rel="stylesheet" href="/resources/demos/style.css" />
<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<script>
 	/* $(function() {
		$("#birth_date").datepicker();
	}); */ 
	$(document).ready(function() {
		$("#back").blur();
		$("#registerpet").validate({

			rules : {

				owner_id : "required",
				pet_name : "required",
				birth_date : "required",
				type : "required"

			},

			messages : {

				owner_id : "Please select owner's Id",
				pet_name : "Please enter pet's name",
				birth_date : "Please enter pet's birth date",
				type : "Please select a category"

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
	padding-left: .5em;
	vertical-align: top;
}
</style>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<form action="register_pet.htm" id="registerpet" method="get">

		<table align="center">
			<tr>
				<td colspan="3" align="center"><h2>
						<fmt:message key="pet.register.header" />
					</h2></td>
			<tr>
			<tr>
				<td><label for="ownerId"><fmt:message
							key="pet.register.label.ownerId" /></label></td>
				<td><select id="owner_id" name="owner_id">
						<option value="">
							<fmt:message key="pet.register.label.select" />
						</option>
						<c:forEach var="al" items="${owner}">
							<option value="${al.own_id}">${al.own_id}
								${al.own_fname} ${al.own_lname}</option>
						</c:forEach>
				</select></td>
				<td><div id="ownerId"></div></td>
			</tr>
			<tr>
				<td><label for="pet_name"><fmt:message
							key="pet.register.label.pet_name" /></label></td>
				<td><input id="pet_name" type="text" name="pet_name" /></td>
				<td><div id="pname"></div></td>
			</tr>
			<tr>
				<td><label for="birth_date"><fmt:message
							key="pet.register.label.birth_date" /></label></td>
				<td><input id="birth_date" type="text" name="birth_date" /></td>
				<td><div id="date">dd-MM-yyyy</div></td>
			</tr>
			<tr>
				<td><label for="type"><fmt:message
							key="pet.register.label.type" /></label></td>
				<td><select name="type" id="type">
						<option value="">
							<fmt:message key="pet.register.label.select" />
						</option>
						<option value="Dog">Dog</option>
						<option value="Cat">Cat</option>
						<option value="Bird">Bird</option>
						<option value="Rat">Rat</option>
				</select></td>
				<td><div id="category"></div></td>
			</tr>
			<tr>
				<td></td>
				<fmt:message key="pet.register.button.submit" var="buttonValue" />
				<td><input type="submit" name="cmd" value="${buttonValue}" />
					<fmt:message key="pet.register.button.reset" var="buttonValue" />
					<input type="reset" value="${buttonValue}" /></td>
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