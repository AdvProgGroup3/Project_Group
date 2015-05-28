<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>
<%
//allow access only if session exists
String user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
String id=null;
String role=null;
String faculty=null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
    if(cookie.getName().equals("user")) userName = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
    if(cookie.getName().equals("id")) id=cookie.getValue();
    if(cookie.getName().equals("role")) role=cookie.getValue();
    if(cookie.getName().equals("faculty")) faculty=cookie.getValue();
}
}
%>
<h3>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h3>
<br>
id=<%=id %>
<br>
User=<%=user %>
<br>
Role=<%=role %>
<br>
<br>
Membership: <%if(!faculty.equals("fasilkom")){ %>
Temporary member<%}else { %>
Long time member<%} %>
<br>
<br>
<%if(role.equals("admin")) {%>
<a href="DeleteAccount.jsp">Delete Account</a>
<br>
<a href="RegisterMaster.jsp">Add Account</a>
<%}%>
	

<br>
<br>
<a href="SpacesList">Checkout Page</a>
<br>
<br>
<a href="BookingServlet">Booking</a>
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
</body>
</html>