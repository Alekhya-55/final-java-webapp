<%@ page import="com.codegnan.finaljavawebapp.entity.*"%>
<%@ page import="com.codegnan.finaljavawebapp.service.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean class="com.codegnan.finaljavawebapp.entity.Employee" id="employee" />
	<jsp:setProperty name="employee" property="employeeId" param="eid" />
	<jsp:setProperty name="employee" property="firstName" param="fName" />
	<jsp:setProperty name="employee" property="lastName" param="lName" />
	<jsp:setProperty name="employee" property="dateOfJoining" param="doj" />
	<jsp:setProperty name="employee" property="email" param="email" />
	<jsp:setProperty name="employee" property="password" param="pass" />

<%!EmployeeService employeeService =  EmployeeService.getInstance();%>

<%
     if(employeeService.signUp(employee)) 
     {
%>
	<h2>
		<font color='green'> SIGN UP SUCCESSFULL </font>
	</h2>

<%
}
else {
%>
	<h2>
		<font color='red'>ERROR SIGNING UP </font>
		TRY AGAIN <a href='sign-up-form.html'>SIGN UP</a>
	</h2>
<%
}
%>
</body>
</html>