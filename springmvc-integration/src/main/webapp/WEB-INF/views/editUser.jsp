<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
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
  
   <h1>Edit User in the System</h1>
   <form:form action="./updateUser" method="post" modelAttribute="updateUser">
   <form:hidden  value="${user.userId}" path="userId"></form:hidden> <br><br> 
        <form:input value="${user.username}" type="text" path="username" placeholder="enter username here"></form:input> <br><br> 
        <form:input value="${user.password}" type="password" path="password" placeholder="enter password"></form:input> <br><br>
         <form:input value="${user.fullname}" type="text" path="fullname"  placeholder="enter fullname"></form:input> <br><br>
         <form:input value="${user.emailId}" type="text" path="emailId"  placeholder="enter emailId"></form:input> <br><br>
         <form:input value="${user.mobileNumber}" type="text" path="mobileNumber"  placeholder="enter mobileNumber"></form:input> <br><br>
        <form:button>Save User</form:button>
   
   </form:form>
   
     <h1>${message} </h1>

</body>
</html>