<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
			tr {
				text-align: center;
			}
		</style>
	</head>
	<body>
		<div id="container">

			<form role="form" action="DailyParkingServlet" method="GET">
				<input type="date" name="date" required>
				<input type="submit" value="submit">
			</form>
		
			<table width="100%" border="1">
				<tr>
					<th>Area ID</th>
					<th>User ID</th>
					<th>Check In Time</th>
					<th>Check Out Time</th>
				</tr>
				${data}
				
				
			</table>
			
		</div>
	</body>
</html>