<%@page import="com.codegnan.finaljavawebapp.entity.*"%>
<%@ page import="com.codegnan.finaljavawebapp.service.*" %>
<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!EmployeeService employeeService =  EmployeeService.getInstance();%>

<jsp:useBean class="com.codegnan.finaljavawebapp.entity.Employee" id="employee" scope="session"/>
<jsp:setProperty name="employee" property="password" param="newpass"/>

<% 
	boolean passwordChangeStatus = employeeService.updateEmployeeLoginPassword(employee.getEmployeeId(), employee.getPassword());
	

	if (passwordChangeStatus) {
		session.invalidate();
%>
		<h2>
			<font color="green">
				Password successfully updated.
			</font>
		</h2>
		
		<a href="sign-in-form.html">Sign In Again</a>
<%
	} else {
%>
		<h2>
			<font color="red">
				Error updating password. Please try again later.
			</font>
		</h2>
			
		<a href="sign-in-form.html">Try Again</a>
<%			
	}
%>
</body>
</html>