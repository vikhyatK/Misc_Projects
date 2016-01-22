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
<title>Pet Appointment</title>
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js">
	
</script>

<script type="text/javascript">
	$(document).ready(function() {

		$("#petIdForm").validate({
			messages : {

				pet_id : "Please enter pet's Id"

			},
			rules : {
				pet_id : "required"
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
	<table align='center'>
		<tr>
			<td colspan="2" align="center"><h2>
					<fmt:message key="pet.appointment.header" />
				</h2></td>
		<tr>
		<tr></tr>
		<tr></tr>
		<tr>
			<td><form id="petIdForm" action="get_pet.htm" method=post>
					<table>
						<tr>
							<td><label for="pet Id"><fmt:message
										key="pet.appointment.label.pet_id" /></label></td>
							<td><input type=text name=pet_id /></td>
						</tr>
						<tr>
							<fmt:message key="pet.appointment.button.submit"
								var="buttonValue" />
							<td><input type='submit' name="cmd" value="${buttonValue}" /></td>
							<td><fmt:message key="owner.register.button.back"
									var="buttonValue" /> <input type="button" id="back"
								value="${buttonValue}" /></td>
						</tr>
					</table>
				</form></td>
		</tr>
		<tr>
			<td></td>

		</tr>

	</table>

</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>