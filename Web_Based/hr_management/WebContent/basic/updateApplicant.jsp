
      <%@ taglib uri="/struts-tags"  prefix="s"%>

      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
      <table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<s:form action="updateapp" namespace="/basic" method="post">
<table>
<tr><td><s:textfield label="Fname" name="fname" value="%{applicant.fname}"/></td></tr>
<tr><td><s:textfield label="Mname" name="mname" value="%{applicant.mname}"/></td></tr>
<tr><td><s:textfield label="Lname" name="lname" value="%{applicant.lname}"/></td></tr>
<tr><td><s:textfield label="Father's Name" name="fathersname" value="%{applicant.fathersname}"/></td></tr>
<tr><td><s:textfield label="Email Id" name="email"  value="%{applicant.email}"/></td></tr>
<tr><td><s:textfield label="Mobile No" name="mobno" maxlength="10" value="%{applicant.mobno}"></s:textfield>
<tr><td><s:textarea label="Permanent Address" name="address" value="%{applicant.address}"></s:textarea>
<tr><td><s:textfield label="Current Location" name="currentlocation" value="%{applicant.currentlocation}"></s:textfield></td></tr>
<tr><td><s:textfield label="High school" name="highschool" value="%{applicant.highschool}"></s:textfield></td></tr>
<tr><td><s:textfield label="Intermediate" name="intermediate" value="%{applicant.intermediate}"></s:textfield></td></tr>
<tr><td><s:select list="#@java.util.HashMap@{'1':'BE','2':'BCA','3':'BSC','4':'Bcomm','5':'B.Tech','6':'M.Tech'}" label="Highest Qualification"  name="highestqualification" value="%{applicant.highestqualification}"></s:select></td></tr>
<tr><td><s:textfield label="Specialization" name="specialization" value="%{applicant.specialization}"/></td></tr>
<tr><td><s:textfield label="Year Of Passing" name="yearofpassing" value="%{applicant.yearofpassing}"/></td></tr>
<tr><td><s:textfield label="Institute/University" name="institute" value="%{applicant.institute}"/></td></tr>
<tr><td><s:textfield label="Skills" name="skills" value="%{applicant.skills}"/></td></tr>
<tr><td><s:select list="#@java.util.HashMap@{'1':'Beginer','2':'Intermediate','3':'Expert'}" label="Expertize Level"  name="expertizelevel" value="%{applicant.expertizelevel}"/></td></tr>
<tr><td><s:textfield label="Work Experience" name="workexperience" value="%{applicant.workexperience}"></s:textfield></td></tr>
<tr><td><s:select list="#@java.util.HashMap@{'1':'Banking','2':'Marketing','3':'Designing','4':'Finance','5':'Hardware','6':'Software'}" label="Area Of Intrest" name="areaofinterest" value="%{applicant.areaofinterest}"/></td></tr>
<tr><td><s:reset value="reset"/></td><td><s:submit value="Update Profile"/></td></tr>
</table>
</s:form>
</td></tr>
</table>