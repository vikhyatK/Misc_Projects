<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
	scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.example.i18n.text" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>Success</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<form action="back.htm">

		<table align="center">
			<tr>
				<td align="right">
					<div style="color: #0000FF">
						<h1>
							${value}
							<fmt:message key="successview.header" />
						</h1>
					</div>
				</td>
			</tr>
			<tr>
				<td align="center"><fmt:message
						key="owner.register.button.back" var="buttonValue" /> <input
					type="submit" value="${buttonValue}" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>