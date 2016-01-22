
       <%@ taglib uri="/struts-tags" prefix="s" %>
     <%@ taglib uri="/struts-dojo-tags" prefix="sx"%>

<html>
<head>
<sx:head/>
</head>
<body>
 <table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<s:form action="schedule" method="post" namespace="/basic">
<table align="center">
<tr><td>Applicant Name</td><td><select  name="appid"><%= request.getAttribute("appids") %></select></td></tr>
<tr><sx:datetimepicker name="interviewDate" label="Interview Date" displayFormat="dd/MM/yyyy"/></tr>
<tr><td>Interviewer Name</td><td><select  name="irid"><%= request.getAttribute("irid") %></select></td></tr> 
<tr><td><s:submit value="Schedule"/>
</table>
</s:form>
</td></tr>
</table>
</body>
</html>