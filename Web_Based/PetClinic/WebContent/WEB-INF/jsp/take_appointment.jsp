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
<title>Appointment Page</title>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />

<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

<script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>

<link rel="stylesheet" href="/resources/demos/style.css" />

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js"></script>

<script>
	 $(function() {
		$("#date").datepicker({
			minDate : -0,
			maxDate : "+10D"
		});
	}); 

	
	$(document).ready(function() {

		$("#appointment").validate({

			rules : {
				vet_id : "required",
				date : "required"
			},

			messages : {
				vet_id : "Please select a vet",
				date : "Please enter visit date"
			}

		});
		
		$("#back").click(function() {
			 window.location = "pet_id.htm";
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
	<form action="appointmentAdd.htm" id="appointment" method="post">


		<table align="center">
			<tr>
				<td colspan="2" align="center"><h2>
						<fmt:message key="appointment.label.header" />
					</h2></td>
			<tr>
			<tr>

				<td><label for="pet_id"> <fmt:message
							key="appointment.label.pet_id" />
				</label></td>
				<td>${pet_Id}<input type="hidden" name="pet_id"
					value="${pet_Id}" /></td>

			</tr>
			<tr>
				<td><label for="vet_id"> <fmt:message
							key="appointment.label.vet_id" />
				</label></td>
				<td><select name="vet_id">
						<option value="">
							<fmt:message key="appointment.label.vet_id.select" />
						</option>
						<c:forEach var="al" items="${vet }">
							<option value="${al.vet_id}">${al.vet_id}-
								${al.vet_fname} ${al.vet_lname}</option>
						</c:forEach>
				</select></td>
			</tr>



			<tr>
				<td><label for="desc"> <fmt:message
							key="appointment.label.desc" />
				</label></td>
				<td><input type="text" name="description" /></td>
			</tr>

			<tr>
				<td><label for="date"> <fmt:message
							key="appointment.label.visit_date" />
				</label></td>
				<td><input type="text" name="date" id="date"
					readonly="readonly" /></td>
			<tr>
				<td></td>
				<td><fmt:message key="appointment.button.submit"
						var="buttonValue" /> <input type="submit" name="cmd"
					value="${buttonValue}" /> <fmt:message
						key="appointment.button.reset" var="buttonValue" /> <input
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
	<%-- <form action="back.htm">
		<table align="center">
			<tr>
				<td><fmt:message key="owner.register.button.back"
						var="buttonValue" /> <input type="submit" id="back"
					value="${buttonValue}" /></td>
			</tr>
		</table>
	</form> --%>
</body>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>
</html>