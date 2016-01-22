
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="style/style.css" type="text/css"
	media="screen,projection" />


<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js"></script>

<script type="text/javascript"
	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.js">
</script>
</head>

<body>

	<% Object var = (request.getSession()).getAttribute("username");
		if(var==null)
		{
			response.sendRedirect("login.htm");
		}
	%>
	<div style="color: #0000FF; text-align: center">
		<h1>
			<fmt:message key="header.welcome" />
		</h1>
	</div>
	<hr></hr>
</body>
</html>