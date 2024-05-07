<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <a href="./createUser">Add User</a> &nbsp;&nbsp;&nbsp; 
 <a href="./listAllUsers">List Users</a> &nbsp;&nbsp;&nbsp;
  <a href="./deleteAllUsers">Delete All</a> &nbsp;&nbsp;&nbsp;
  <a href="./updateUser">Update User</a> &nbsp;&nbsp;&nbsp;
  <a href="./getUser">Get User</a> &nbsp;&nbsp;&nbsp;
  <a href="./deleteUser">Delete User</a>  <br><br>
  <h1>All users!</h1>

  <table border="1" width="100%">
            <caption><h3>Users List:</h3></caption>
            <thead>
                <tr class="tr tr-success">
                    <td>Username</td>
                    <td>EmailId</td>
                    <td>Mobile Number</td>
                     <td colspan="2">Operation</td>
                </tr>   
            </thead>
            <tbody>
                <c:forEach items="${usersList}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.emailId}</td>
                        <td>${user.mobileNumber}</td>
                        <td><a href="./deleteUser?uid=${user.userId}">delete</a></td>
                        <td><a href="./editUser?uid=${user.userId}">edit</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
          <h2>${message}</h2>
</body>
</html>