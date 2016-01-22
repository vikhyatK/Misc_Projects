<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<%@ include file="/WEB-INF/jsp/footer.jsp"%>
<%@ include file="/WEB-INF/jsp/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
<script type="text/javascript">

	function name(){

		alert("aaa");
		}

</script>
</head>
<body>

<form action="change_price1.htm">
	<table align="center" border="1">
		<tr colspan="4" align="center"><h4>Products</h4></tr>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Update</th>
		</tr>

		<tr>
		   <td><input type="label" name="id" value="${product.id}" readonly="true"></td>
           <td><input type="textbox" name="pname" value="${product.name}"></td>
           <td><input type="textbox" name="price" value="${product.price}"></td>
           <td><input type="submit" value="Update"/></td>
        </tr>
		


	</table>
	</form>
</body>
</html>