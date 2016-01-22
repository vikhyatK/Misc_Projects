<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="/struts-tags"  prefix="s"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<s:form action="applicant" namespace="/basic" method="post">
<table>
<tr><td><s:textfield label="Fname" name="fname"/></td></tr>
<tr><td><s:textfield label="Mname" name="mname"/></td></tr>
<tr><td><s:textfield label="Lname" name="lname"/></td></tr>
<tr><td><s:textfield label="Father's Name" name="fathersname"/></td></tr>
<tr><td><s:textfield label="Email Id" name="email" required="true"/></td></tr>
<%-- <tr><td><s:textfield label="Desired User Name" name="username" required="true"/></td></tr> --%>
<tr><td><s:password label="Password" name="password" required="true"/></td></tr>
<tr><td><s:password label="Re-Type Password" name="repassword" required="true"/></td></tr>
<%-- <tr><td><s:radio  name="Gender"   list={"Male","Female"}></s:radio></td></tr> --%>
<tr><td><s:radio list="1" label="Gender" name="gender" value="Male"></s:radio></td></tr>
<tr><td><s:radio list="1" name="gender" value="FeMale"></s:radio></td></tr>
<tr><td><s:textfield label="Mobile No" required="true" name="mobno" maxlength="10"></s:textfield>
<tr><td><s:textarea label="Permanent Address" name="address"></s:textarea>
<tr><td><s:textfield label="Current Location" name="currentlocation"></s:textfield></td></tr>
<tr><td><s:textfield label="High school" name="highschool"></s:textfield></td></tr>
<tr><td><s:textfield label="Intermediate" name="intermediate"></s:textfield></td></tr>
<tr><td><s:select list="#@java.util.HashMap@{'1':'BE','2':'BCA','3':'BSC','4':'Bcomm','5':'B.Tech','6':'M.Tech'}" label="Highest Qualification"  name="highestqualification"></s:select></td></tr>
<tr><td><s:textfield label="Specialization" name="specialization"></s:textfield></td></tr>
<tr><td><s:textfield label="Year Of Passing" name="yearofpassing"></s:textfield></td></tr>
<tr><td><s:textfield label="Institute/University" name="institute"></s:textfield></td></tr>
<tr><td><s:textfield label="skills" name="skills"></s:textfield></td></tr>
<tr><td><s:select list="#@java.util.HashMap@{'1':'Beginer','2':'Intermediate','3':'Expert'}" label="Expertize Level"  name="expertizelevel"></s:select></td></tr>
<tr><td><s:textfield label="Work Experiance" name="workexperiance"></s:textfield></td></tr>
<tr><td><s:select list="#@java.util.HashMap@{'1':'Banking','2':'Marketing','3':'Designing','4':'Finance','5':'Hardware','6':'Software'}" label="Area Of Intrest" name="areaofinterest" ></s:select></td></tr>
<tr><td><s:textfield label="Enter Secure Code" name="securecode"></s:textfield></td></tr>
<s:checkbox label="I understand terms and conditions" name="statusoflicense"></s:checkbox>
<tr><td><s:reset value="reset"/></td><td><s:submit value="Register"/></td></tr>

</table>
</s:form>
<!-- <h2><form action="applicant" namespace="/basic" method="post"></h2><br/><br/>
ApplicantName:<input type="text" name="appname" >
<input type="submit" value="Add Applicant"> 
</form>-->
</body>
</html>