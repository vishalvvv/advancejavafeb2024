<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <form:form action="./authenticate" method="post" modelAttribute="user">
  <form:input type="text" path="username" placeholder="enter username here"></form:input>
  <form:input type="password" path="password" placeholder="enter password"></form:input>
  <form:button>Login</form:button>
 </form:form> 
 
   <h1> ${message} </h1>  

</body>
</html>