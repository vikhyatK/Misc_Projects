
        <%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<table border="1">
 <tr>
<th>EmpId</th>
<th>DeptId</th>
<th>VacancyID</th>
<th>OpeningDate</th>
<th>OwnedBy</th>
<th>Status</th>
<th>Title</th>
<th>Description</th>
<th>JobOpenings</th>
<th>ClosingDate</th>
</tr> 
<s:iterator id="itera" value="#session.vac">

<tr><td align="center"><s:property value="#itera.employee.getEmpid()"/></td>
<td align="center"><s:property value="#itera.deptid"/></td>
<td align="center"><s:property value="#itera.vid"/></td>
<td align="center"><s:property value="#itera.openingdate"/></td>
<td align="center"><s:property value="#itera.ownedby"/></td>
<td align="center"><s:property value="#itera.status"/></td>
<td align="center"><s:property value="#itera.title"/></td>
<td align="center"><s:property value="#itera.description"/></td>
<td align="center"><s:property value="#itera.jobopenings"/></td>
<td align="center"><s:property value="#itera.closingdate"/></td></tr>
</s:iterator>
</table>
</td></tr>
</table>