<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML>
<html>
<head>
<title>User Form</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>

<div id="container">

<h2>Registration Form:</h2>

<form:form modelAttribute="subscriber" method="POST" action="register">

	<table>

		<tr>
			<td><label for="nameInput">Name: </label></td>
			<td><form:input path="name" id="nameInput" /><br/></td>
			<td><form:errors path="name" cssClass="error"/></td>
		</tr>
		<tr>
			<td><label for="ageInput">Age: </label></td>
			<td><form:input path="age" id="ageInput" /><br/></td>
		</tr>
		<tr>
		<td><label for="emailInput">Email: </label></td>
		<td><form:input path="email" id="emailInput" /><br/></td>
		<td><form:errors path="name" cssClass="error"/></td>
	</tr>
		
		<tr>
			<td><label for="genderOptions">Gender: </label></td>
			<td><form:select path="gender" id="genderOptions">
				<form:option value="">Select Gender</form:option>
				<form:option value="MALE">Male</form:option>
				<form:option value="FEMALE">Female</form:option>
			</form:select><br/></td>
		</tr>
		<tr>
			<td><label for="newsletterCheckbox">Newsletter? </label></td>
			<td><form:checkbox path="receiveNewsletter"
				id="newsletterCheckbox" /><br/></td>
				
			<td><label for="frequencySelect">Freq:</label></td>
			<td><form:select path="newsletterFrequency" id="frequencySelect">
				<form:option value="">Select Newsletter Frequency: </form:option>
				<c:forEach items="${frequencies}" var="frequency">
					<form:option value="${frequency}">${frequency}</form:option>
				</c:forEach>
			</form:select><br/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		</table>
</form:form></div>


<script type="text/javascript">
	
		$(document).ready(function() {
			
			toggleFrequencySelectBox(); // show/hide box on page load
			
			$('#newsletterCheckbox').change(function() {
				toggleFrequencySelectBox();
			});
			
		});
		
		function toggleFrequencySelectBox() {
			if(!$('#newsletterCheckbox').is(':checked')) {
				$('#frequencySelect').val('');
				$('#frequencySelect').prop('disabled', true);
			} else {
				$('#frequencySelect').prop('disabled', false);
			}
		}
	
	</script>

</body>
</html>