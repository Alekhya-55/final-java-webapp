package com.codegnan.finaljavawebapp.service;

import java.util.ArrayList;

import com.codegnan.finaljavawebapp.dao.EmployeeDao;
import com.codegnan.finaljavawebapp.entity.Employee;

public class EmployeeService {
	
	EmployeeDao employeeDao = EmployeeDao.getInstance();

	private static EmployeeService employeeService;
	
	private EmployeeService() {
		System.out.println("EmployeeService");
	}
	
	public static EmployeeService getInstance() {
		   if(employeeService == null) {
			   employeeService = new EmployeeService();
		   }
		   
		   return employeeService;
	}
	
	
	public boolean signUp(Employee employee) {
		return employeeDao.insertEmployee(employee);
	}
	
	public boolean signIn(Employee employee) {
		return employeeDao.searchEmployeeByEmailAndPassword(employee);
	}
	
	public ArrayList<Employee> displayEmployees() {
		return employeeDao.selectAllEmployees();
	}
	
	public boolean updateEmployeeLoginPassword(int employeeId, String password) {
		 return employeeDao.updateEmployeeLoginPassword(employeeId, password);	
	}
	
	public boolean updateEmployeeEmailId(int employeeId, String newEmailId) {
		return employeeDao.updateEmployeeEmailId(employeeId, newEmailId);
	}
	
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		   return employeeDao.removeEmployeeByEmployeeId(employeeId);
	}
}

