 <%@ taglib uri="/struts-tags" prefix="s" %>
 <table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<table border="1">
<tr>
<!-- <th>Select</th> -->
<th>VacancyID</th>
<th>DeptId</th>
<th>Title</th>
<th>Description</th>
<th>Status</th>
<th>JobOpenings</th>
<th>OpeningDate</th>
<th>ClosingDate</th>
<th>Edit</th>
</tr>
<s:iterator id="itera" value="list">
<tr>
<%--  <td><s:radio name="vac" value="#itera.vid" list="#{key:''}" /></td> --%>
<%-- <tr><s:radio theme="simple" name="vac" list="#{objId:objId}"/> --%>
<td align="center"><s:property value="#itera.vid"/></td>
<td align="center"><s:property value="#itera.deptid"/></td>
<td align="center"><s:property value="#itera.title"/></td>
<td align="center"><s:property value="#itera.description"/></td>
<td align="center"><s:property value="#itera.status"/></td>
<td align="center"><s:property value="#itera.jobopenings"/></td>
<td align="center"><s:property value="#itera.openingdate"/></td>
<td align="center"><s:property value="#itera.closingdate"/></td>
<s:url action="edit.action" id="edit" ><s:param name="vid"><s:property value="#itera.vid" /></s:param></s:url>
<td> <a href="<s:property value="#edit"/>" >Edit</a></td>
</tr>
</s:iterator>
</table>
</td></tr>
</table>