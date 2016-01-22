<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
<title><tiles:getAsString name="title"/></title>
<link rel="stylesheet" href="mystyle.css" type="text/css" />
</head>
<body topmargin="0">
<table width="800" cellspacing="0" align="center" >
  <tr>
     <td colspan="2" height="70"><tiles:insertAttribute name="header"/></td>
  </tr>
  <tr height="300">
  	<td width="200" valign="top"><tiles:insertAttribute name="menu"/></td>
    <td width="600"><tiles:insertAttribute name="body"/></td>
  </tr>
   <tr>
     <td colspan="2" height="70"><tiles:insertAttribute name="footer"/></td>
  </tr>
</table> 
</body>
</html>
          