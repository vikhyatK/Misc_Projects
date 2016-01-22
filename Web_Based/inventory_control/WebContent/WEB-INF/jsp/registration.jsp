<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<center>
		<h1>
			<b><u>Register Here</u> </b>
		</h1>
		<hr>
		<form action="register.htm" id="login" method=post>
			<table>
				<tr>
					<td align='right'>Name</td>
					<td align='left'><input type="text" name="name">
					</td>
				</tr>
				
				
				<tr>
					<td align='right'>UserID</td>
					<td align='left'><input type="text" name="userid">
					</td>
				</tr>
				<tr>
					<td align='right'>Password</td>
					<td align='left'><input type="password" name="password">
					</td>
				</tr>
				<tr>
					<td align='right'>ContactNo.</td>
					<td align='left'><input type="text" name="phone">
					</td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" name="hidden" value="RegisterUser"><input
						type='reset' value='Reset' />
					</td>
				</tr>
			</table>
		</form>
		<hr>
		
		<hr>

	</center>


</body>
</html>