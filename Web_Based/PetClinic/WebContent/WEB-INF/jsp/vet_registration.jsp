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
<title>Vet Registration</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js">
	
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#registervet").validate({
			messages : {

				vet_fname : "Please enter vet's firstname",
				vet_lname : "Please enter vet's lastname",
				phone : "Please enter vet's phone number",
				speciality : "Please enter vet's speciality"
			},
			rules : {
				vet_fname : "required",
				vet_lname : "required",
				phone : "required",
				speciality : "required"
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
	<form method="post" id="registervet" action="register_vet.htm">
		<table align="center">
			<tr>
				<td colspan="2" align="center"><h2>
						<fmt:message key="vet.register.header" />
					</h2></td>
			<tr>
			<tr>
				<td><label for="firstname"><fmt:message
							key="vet.register.label.vet_fname" /></label></td>
				<td><input type="text" name="vet_fname" /></td>
			</tr>

			<tr>
				<td><label for="lastname"><fmt:message
							key="vet.register.label.vet_lname" /></label></td>
				<td><input type="text" name="vet_lname" /></td>
			</tr>

			<tr>
				<td><label for="speciality"><fmt:message
							key="vet.register.label.speciality" /></label></td>
				<td><select name="speciality" id="speciality">
						<option value="">
							<fmt:message key="pet.register.label.select" />
						</option>
						<option value="Neurology">Neurology</option>
						<option value="Dentist">Dentist</option>
						<option value="Birdspecialist">Bird Specialist</option>
						<option value="Oncology">Oncology</option>
						<option value="Parasitology">Parasitology</option>
				</select></td>
			</tr>

			<tr>
				<td><label for="phone"><fmt:message
							key="vet.register.label.phone" /></label></td>
				<td><input type="text" name="phone" /></td>
			</tr>

			<tr>
				<td></td>
				<fmt:message key="vet.register.button.submit" var="buttonValue" />
				<td><input type="submit" value="${buttonValue}" /> <fmt:message
						key="vet.register.button.reset" var="buttonValue" /> <input
					type="reset" value="${buttonValue}" /></td>
			</tr>
			<tr>
				<td></td>
				<td><fmt:message key="owner.register.button.back"
						var="buttonValue" /> <input type="button" id="back" value="${buttonValue}" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>