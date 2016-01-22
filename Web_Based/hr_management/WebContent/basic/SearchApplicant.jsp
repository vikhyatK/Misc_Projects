<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertTemplate template="/layout.jsp">
  <tiles:putAttribute name="title"  value="Search Applicant" type="string"/>
  <tiles:putAttribute name="header" value="/header.jsp" />
  <tiles:putAttribute name="menu" value="/hr_menu.jsp"/>
  <tiles:putAttribute name="body"   value="/basic/SearchApplicantForm.jsp" />
  <tiles:putAttribute name="footer" value="/footer.jsp" />
</tiles:insertTemplate>