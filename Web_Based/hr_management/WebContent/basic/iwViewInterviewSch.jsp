 <%@ taglib uri="/struts-tags" prefix="s" %>
 <table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<table border="1">
<tr>
<th>ApplyVacancy ID</th>
<th>Applicant Name</th>
<th>Vacancy Title</th>
<th>Apply Date</th>
<th>Schedule Date</th>
<th>HR Name</th>
</tr>
<s:iterator id="itera" value="list">
<tr>
<td align="center"><s:property value="#itera.apvacancyid"/></td>
<td align="center"><s:property value="#itera.applicant.fname"/></td>
<td align="center"><s:property value="#itera.vacancy.title"/></td>
<td align="center"><s:property value="#itera.applydate"/></td>
<td align="center"><s:property value="#itera.scheduledate"/></td>
<td align="center"><s:property value="#itera.employee2.fname"/></td>
</tr>
</s:iterator>
</table>
</td></tr>
</table>