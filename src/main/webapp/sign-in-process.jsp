<%@ page import="com.codegnan.finaljavawebapp.entity.Employee"%>
<%@page import="com.codegnan.finaljavawebapp.service.EmployeeService"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean class="com.codegnan.finaljavawebapp.entity.Employee" id="employee"  scope="session"/>
	<jsp:setProperty name="employee" property="email" param="email" />
	<jsp:setProperty name="employee" property="password" param="pass" />

<%!EmployeeService employeeService =  EmployeeService.getInstance();%>

	<%
if(employeeService.signIn(employee)) {
%>
	<h2>
		<font color="green"> SIGNED IN SUCCESSFULLY...<br> 
		WELCOME <jsp:getProperty name="employee" property="firstName"/> 
		        <jsp:getProperty name="employee" property="lastName" />
		</font>
	</h2>
	<a href="update-email-form.html">UPDATE EMAIL</a>
	<a href="update-password-form.html">UPDATE PASSWORD</a>
	<%
	}
	else{
%>
	<h2>
		<font color="red"> INVALID ACCESS. TRY AGAIN </font>
	</h2>
	<a href="sign-in-form.html">SIGNIN</a>
	<%
}
%>

</body>
</html>