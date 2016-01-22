<%@ taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td class="text" align="center">
| Successful Login!|
<br><br><b><s:property value="#session.msg"/></b>
<c:remove var="msg" scope="session"/>
<br><br>
You have logged in as : <b><s:property value="#session.eid"/></b>
<br><br><br><br>
| Use Navigation Links provided in Menu Bar. |
</td></tr>
</table>
