<%@ taglib prefix="s" uri="/struts-tags" %>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<s:form action="adminChangePass" namespace="/basic">
<table>
<tr><td><s:password name="oldpass" label="Original Password" /></td></tr>
<tr><td><s:password name="newpass" label="New Password"/></td></tr>
<tr><td><s:password name="password" label="ConfirmPassword"/></td></tr>
<tr><td><s:submit label="ChangePassword"></s:submit>
</table>
</s:form>
</td></tr>
</table>