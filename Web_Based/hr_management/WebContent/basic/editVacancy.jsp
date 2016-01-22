<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@taglib prefix="sx" uri="/struts-dojo-tags"%>
<html>
<head>
<sx:head/>
</head>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>

<s:form name="EditVac" method="post" action="editVacanc" namespace="/basic" >
	<table align="center" >
		<tr><td><s:textfield label="Title" name="title" value="%{vaca.title}"/></td></tr>
		<tr><td><s:textfield label="Dept Id" name="deptid" value="%{vaca.deptid}"/></td></tr>
		<tr><td><s:textarea label="Description" name="description" value="%{vaca.description}"/></td></tr>
		<tr><td><s:textfield  name="ownedby" label="owned by" value="%{vac.ownedby}"/></td></tr>
		<tr><td><s:textfield label="Job Openings" name="jobopenings" value="%{vaca.jobopenings}"/></td></tr>
		<tr><td><sx:datetimepicker label="Date of Closing" displayFormat="dd/MM/yyyy" name="closingdate" value="%{vaca.closingdate}"/></td></tr> 
		<tr><td colspan="2" align="right"><input type="submit" value="Edit"/></td></tr>
</table>	
</s:form>
</td></tr>
</table>
</html>
