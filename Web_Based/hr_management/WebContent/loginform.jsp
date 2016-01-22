<%@ taglib prefix="s" uri="/struts-tags" %>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td class="text" align="center">
<h3><img src="/hr_management/images/sm-icon3.gif" alt="">   Login</h3>
<br><s:actionerror/>
<s:form action="login" method="post" namespace="/basic" cssClass="text">
	<s:textfield name="eid" label="Login Id"/>
	<s:password name="epassword" label="Password"/>
	<s:submit value="Login"/>
	<a href="/hr_management/applicantRegisteration.jsp" >Register As Applicant</a>
</s:form>
</td></tr>
</table>