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
  
   <h1>Add User to the System</h1>
   <form:form action="./addUser" method="post" modelAttribute="user">
        <form:input type="text" path="username" placeholder="enter username here"></form:input> <br><br> 
        <form:input type="password" path="password" placeholder="enter password"></form:input> <br><br>
         <form:input type="text" path="fullname"  placeholder="enter fullname"></form:input> <br><br>
         <form:input type="text" path="emailId"  placeholder="enter emailId"></form:input> <br><br>
         <form:input type="text" path="mobileNumber"  placeholder="enter mobileNumber"></form:input> <br><br>
        <form:button>Add User</form:button>
   
   </form:form>
   
     <h1>${message} </h1>

</body>
</html>