
     <%@ taglib uri="/struts-tags"  prefix="s"%>
<table bgcolor="#a362b3" width="400" align="center" cellpadding="10">
<tr><td>
<center><h2>Selected Applicant Details</h2></center>
<table align="center" border="1">
<s:iterator id="itera" value="#session.appli">
<tr><td>Applicant Id</td><td><s:property value="#itera.appid"/></td></tr>
<tr><td>First Name</td><td><s:property value="#itera.fname "/></td></tr>
 <tr><td>Middle Name</td><td><s:property value="#itera.mname"/></td></tr>
 <tr><td>Last Name</td><td><s:property value="#itera.lname"/></td></tr>
<tr><td>Status</td><td><s:property value="#itera.status"/></td></tr>
<tr><td>Address</td><td><s:property value="#itera.address"/></td></tr>
<tr><td>Area Of Interest</td><td><s:property value="#itera.areaofinterest"/></td></tr>
<tr><td>Current Location</td><td><s:property value="#itera.currentlocation"/></td></tr>
<tr><td>Email</td><td><s:property value="#itera.email"/></td></tr>
<tr><td>Expertize Level</td><td><s:property value="#itera.expertizelevel"/></td></tr>
<tr><td>Fathers Name</td><td><s:property value="#itera.fathersname"/></td></tr>
<tr><td>Gender</td><td><s:property value="#itera.gender"/></td></tr>
<tr><td>Highest Qualification</td><td><s:property value="#itera.highestqualification"/></td></tr>
<tr><td>Year Of Passing</td><td><s:property value="#itera.yearofpassing"/></td></tr>
<tr><td>High School</td><td><s:property value="#itera.highschool"/></td></tr>
<tr><td>Institute</td><td><s:property value="#itera.institute"/></td></tr>
<tr><td>Intermediate</td><td><s:property value="#itera.Intermediate"/></td></tr>
<tr><td>Skills</td><td><s:property value="#itera.skills"/></td></tr>
<tr><td>Specialization</td><td><s:property value="#itera.specialization"/></td></tr>
<tr><td>WorkExperience</td><td><s:property value="#itera.workexperience"/></td></tr>
</s:iterator>
</table>
</td></tr>
</table>