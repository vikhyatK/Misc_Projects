
    <%@ taglib uri="/struts-tags"  prefix="s"%>
    <%@taglib uri="/struts-dojo-tags" prefix="sx"%>
    <html>
    <head><sx:head/>
    </head>
    <body>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td><s:actionerror/>
<s:form action="iwApplicants" method="post">
<sx:datetimepicker label="Enter Interview Date" name="interviewDate" displayFormat="dd-MMM-yyyy" />
	<s:submit value="Search"/>
</s:form>
</td></tr>
</table>
</body>
    </html>