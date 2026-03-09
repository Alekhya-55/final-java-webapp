<%@ page import="com.codegnan.finaljavawebapp.service.*" %>
<%@page import="com.codegnan.finaljavawebapp.entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
     EmployeeService employeeService = EmployeeService.getInstance();
%>

<% 
	int employeeId = Integer.parseInt(request.getParameter("eid"));

	boolean employeeDeleteStatus = employeeService.deleteEmployeeByEmployeeId(employeeId);

	if (employeeDeleteStatus) {
%>
		<h2>
			<font color="green">
				Employee successfully deleted.
			</font>
			<br><a href="employee-list.jsp">EMPLOYEELIST</a>
		</h2>
<%
	} else {
%>
		<h2>
			<font color="red">
				Error deleting employee. Please try again later.
			</font>
		</h2>
<%			
	}
%>
</body>
</html>