<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
  String username=request.getParameter("username");
  String password = request.getParameter("password");
  String email = request.getParameter("email");
  out.print("<h1>" + username+"&nbsp;&nbsp;&nbsp;"+password+"&nbsp;&nbsp;&nbsp;"+email+"</h1>");
%>




</body>
</html>