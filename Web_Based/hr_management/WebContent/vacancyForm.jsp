<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<sx:head/>
</head>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<s:form name="crevac" method="post" action="createvacancy">
	<table align="center" >
		<tr><td><s:textfield label="Title" name="title" /></td></tr>
		<tr><td><s:textfield label="Dept Id" name="deptid" /></td></tr>
		<tr><td><s:textarea label="Description" name="description" /></td></tr>
		<tr><td><s:textfield  name="ownedby" label="owned by" /></td></tr>
		<tr><td><s:textfield label="Job Openings" name="jobopenings" /></td></tr>
		<tr><td><sx:datetimepicker label="Date of Closing" displayFormat="dd/MM/yyyy" name="closingdate"/></td></tr> 
		<tr><td align="center"><s:submit value="Create Vacancy" /></td></tr>
</table>	
</s:form>
</td></tr>
</table>
</html>
