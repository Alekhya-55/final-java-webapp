package com.codegnan.finaljavawebapp.entity;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String dateOfJoining;
	private String email;
	private String password;
	
	public Employee() {
		System.out.println("Employee");
	}
	
	
	public Employee(int employeeIsd, String firstName, String lastName, String dateOfJoining, String email, String password) {
		super();
		System.out.println("int String String String  String String");
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfJoining = dateOfJoining;
		this.email = email;
		this.password = password;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
