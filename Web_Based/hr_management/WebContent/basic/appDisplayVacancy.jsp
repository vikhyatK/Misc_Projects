 <%@ taglib uri="/struts-tags" prefix="s" %>
 <table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<table border="1">
<tr>
<th>VacancyID</th>
<th>Title</th>
<th>Description</th>
<th>JobOpenings</th>
<th>OpeningDate</th>
<th>ClosingDate</th>
<th>Apply</th>
</tr>
<s:iterator id="itera" value="list">
<tr>
<td align="center"><s:property value="#itera.vid"/></td>
<td align="center"><s:property value="#itera.title"/></td>
<td align="center"><s:property value="#itera.description"/></td>
<td align="center"><s:property value="#itera.jobopenings"/></td>
<td align="center"><s:property value="#itera.openingdate"/></td>
<td align="center"><s:property value="#itera.closingdate"/></td>
<s:url action="applyvac.action" id="apply" ><s:param name="vid"><s:property value="#itera.vid" /></s:param></s:url>
<td> <a href="<s:property value="#apply"/>" >Apply</a></td>
</tr>
</s:iterator>
</table>
</td></tr>
</table>