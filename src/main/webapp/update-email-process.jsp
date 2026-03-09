<%@ page import="com.codegnan.finaljavawebapp.service.*" %>
<%@page import="com.codegnan.finaljavawebapp.entity.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!EmployeeService employeeService =  EmployeeService.getInstance();%>

<jsp:useBean class="com.codegnan.finaljavawebapp.entity.Employee" id="employee" scope="session"/>
<jsp:setProperty name="employee" property="email" param="newemail"/>

<% 
	boolean emailidChangeStatus = employeeService.updateEmployeeEmailId(employee.getEmployeeId(), employee.getEmail());

	if (emailidChangeStatus) {
		session.invalidate();
%>
		<h2>
			<font color="green">
				Email ID successfully updated.
			</font>
		</h2>
		
		<a href="sign-in-form.html">Sign In Again</a>
<%
	} else {
%>
		<h2>
			<font color="red">
				Error updating Email ID. Please try again later.
			</font>
		</h2>
			
		<a href="sign-in-form.html">Try Again</a>
<%			
	}
%>

</body>
</html>