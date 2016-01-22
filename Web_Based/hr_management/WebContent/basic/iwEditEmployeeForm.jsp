<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<sx:head/>
</head>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<s:form action="iwupdateEmploy" method="post" namespace="/basic">
	<table align="center" >
		<tr><td><s:textfield label="First Name" name="fname" value="%{emp.fname}"/></td></tr>
		<tr><td><s:textfield label="Middle Name" name="mname" value="%{emp.mname}"/></td></tr>
		<tr><td><s:textfield label="Last Name" name="lname" value="%{emp.lname}"/></td></tr>
		<tr><td><s:textarea label="Address" name="address" value="%{emp.address}" rows="3" cols="15"/></td></tr>
		<tr><td><s:textfield label="Location" name="location" value="%{emp.location}"/></td></tr>
		<tr><td><s:textfield label="Email" name="email" value="%{emp.email}"/></td></tr>
		<tr><td><s:textfield  name="bloodgroup" label="Blood Group" value="%{emp.bloodgroup}"/></td></tr>
		<tr><td><s:textfield label="PassportNumber" name="passport" value="%{emp.passport}"/></td></tr>
		<tr><td><s:textfield label="Contact Number" name="emob" value="%{emp.emob}"/></td></tr>	
		<tr><td align="center"><s:submit value="Update Profile" /></td></tr>
</table>	
</s:form>
</td></tr>
</table>
</html>