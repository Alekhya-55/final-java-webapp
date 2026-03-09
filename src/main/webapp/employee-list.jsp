<%@ page import="com.codegnan.finaljavawebapp.entity.Employee" %>
<%@ page import="com.codegnan.finaljavawebapp.service.EmployeeService" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	EmployeeService employeeService =  EmployeeService.getInstance();
%>
<table border='1'>
<tr>
	<th>EMPLOYEEID</th>
	<th>FIRSTNAME</th>
	<th>LASTNAME</th>
	<th>EMAIL</th>
	<th>DATEOFJOINING</th>
	<th>PASSWORD</th>
</tr>
<%
	ArrayList<Employee> employeeList =  employeeService.displayEmployees();
	for(Employee e : employeeList) {
%>
<tr>
	<td><%= e.getEmployeeId() %></td>
	<td><%= e.getFirstName() %></td>
	<td><%= e.getLastName() %></td>
	<td><%= e.getEmail() %></td>
	<td><%= e.getDateOfJoining() %></td>
	<td><%= e.getPassword() %></td>
	<td><a href="delete-employee-process.jsp?eid=<%=e.getEmployeeId() %>">DELETE</a></td>
</tr>
<%
    }
%>
</table>
</body>
</html>