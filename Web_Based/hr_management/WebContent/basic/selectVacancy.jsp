 <%@ taglib uri="/struts-tags" prefix="s" %>
 <table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<s:form action="getAppVac" namespace="/basic">
 <tr><td>Vacancy Name</td><td><select  name="VID"><%= request.getAttribute("vaca") %></select></td></tr> 
<tr><td>
<s:submit value="Schedule Interview"/>
</tr>
</s:form>
</td></tr>
</table>