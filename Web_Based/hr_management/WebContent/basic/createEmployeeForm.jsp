
    <%@ taglib uri="/struts-tags" prefix="s" %>
    <%@ taglib uri="/struts-dojo-tags" prefix="sx"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<sx:head/>
</head>
<body>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<s:form action="CreEmployee" method="post" namespace="/basic">
<s:textfield label="First Name" name="fname"/>
<s:textfield label="Last Name" name="lname"/>
<sx:datetimepicker name="joiningdate" label="Date of Joining" displayFormat="dd-MM-yyyy" />
<s:password label="Password" name="password"/>
<%-- <s:textfield label="Role" name="role"/> --%>
<s:select list="#@java.util.HashMap@{'hr':'HR','iw':'Interviewer','admin':'Admin'}" label="Role" name="role" ></s:select>
<s:textfield label="Dept ID" name="deptid"/>
<s:submit value="Create Employee" />
</s:form>
</td></tr>
</table>
</body>
</html>