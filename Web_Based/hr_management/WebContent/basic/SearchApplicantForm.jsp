
    <%@ taglib uri="/struts-tags"  prefix="s"%>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td><s:actionerror/>
<s:form action="searchapplicant" method="post">
<s:textfield label="Enter The Applicant ID" name="appid"/></td></tr>
	<s:submit value="Search"/>
</s:form>
</td></tr>
</table>