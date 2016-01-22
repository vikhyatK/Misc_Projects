<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<table align="center" border="1">
		<tr colspan="4" align="center"><h4>Products</h4></tr>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Quantity</th>
		</tr>

		<c:forEach var="al" items="${product}">
			<tr>
			<td>${al.id}</td>
           <td>${al.name}</td>
           <td>${al.price}</td>
           <td>${al.quantity}</td>
           </tr>
		</c:forEach>


	</table>
</body>
</html>