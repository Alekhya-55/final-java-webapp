package com.codegnan.finaljavawebapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.codegnan.finaljavawebapp.entity.Employee;


public class EmployeeDao {
	
	private static EmployeeDao employeeDao;
	
	private EmployeeDao() {
		System.out.println("EmployeeDao");
	}
	
	public static EmployeeDao getInstance() {
		   if(employeeDao == null) {
			   employeeDao = new EmployeeDao();
		   }
		   
		   return employeeDao;
	}
	
	public boolean insertEmployee(Employee employee) {
		
		boolean isEmployeeInserted = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "Insert into signup2 values(?, ?, ?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "alekya");

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, employee.getEmployeeId());
			preparedStatement.setString(2, employee.getFirstName());
			preparedStatement.setString(3, employee.getLastName());
			preparedStatement.setString(4, employee.getEmail());
			preparedStatement.setString(5, employee.getDateOfJoining());
			preparedStatement.setString(6, employee.getPassword());

			int insertionRowsAffected = preparedStatement.executeUpdate();
			if (insertionRowsAffected != 0) {
				isEmployeeInserted = true;
			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException foundException) {
			foundException.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}

		return isEmployeeInserted;

	}

	public boolean searchEmployeeByEmailAndPassword(Employee employee) {

		boolean isEmployeeFound = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM signup2 WHERE email=? and password=?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "alekya");

			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setString(1, employee.getEmail());
			preparedStatement.setString(2, employee.getPassword());

			resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				isEmployeeFound = true;

				employee.setEmployeeId(resultSet.getInt(1));
				employee.setFirstName(resultSet.getString(2));
				employee.setLastName(resultSet.getString(3));
				employee.setDateOfJoining(resultSet.getString(5));

			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException foundException) {
			foundException.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return isEmployeeFound;
	}

	public ArrayList<Employee> selectAllEmployees() {
		ArrayList<Employee> employeesList = new ArrayList<Employee>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "SELECT * FROM signup2 ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "alekya");

			preparedStatement = connection.prepareStatement(query);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();

				employee.setEmployeeId(resultSet.getInt(1));
				employee.setFirstName(resultSet.getString(2));
				employee.setLastName(resultSet.getString(3));
				employee.setEmail(resultSet.getString(4));
				employee.setDateOfJoining(resultSet.getString(5));
				employee.setPassword(resultSet.getString(6));

				employeesList.add(employee);

			}
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (ClassNotFoundException foundException) {
			foundException.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException exception) {
				exception.printStackTrace();
			}
		}
		return employeesList;

	}
	
	public boolean removeEmployeeByEmployeeId(int employeeId) {
		boolean isEmployeeDeleted = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "alekya");
			String sqlQuery = "DELETE FROM signup2 WHERE employee_id=?";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setInt(1, employeeId);
			
			int noOfRowsAffected = preparedStatement.executeUpdate();
			if (noOfRowsAffected != 0) {
				isEmployeeDeleted = true;
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		return isEmployeeDeleted;
	}
	
	public boolean updateEmployeeLoginPassword(int employeeId, String newPassword) {
		boolean isEmployeeLoginPasswordUpdated = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "alekya");
			String sqlQuery = "UPDATE signup2 SET password=? WHERE employee_id=?";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setString(1, newPassword);
			preparedStatement.setInt(2, employeeId);
			
			int noOfRowsAffected = preparedStatement.executeUpdate();
			if (noOfRowsAffected != 0) {
				isEmployeeLoginPasswordUpdated = true;
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		return isEmployeeLoginPasswordUpdated;
	}

	public boolean updateEmployeeEmailId(int employeeId, String newEmailId) {
		boolean isEmployeeEmailIdUpdated = false;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javadb", "root", "alekya");
			String sqlQuery = "UPDATE signup2 SET Email=? WHERE employee_id=?";
			preparedStatement = connection.prepareStatement(sqlQuery);

			preparedStatement.setString(1, newEmailId);
			preparedStatement.setInt(2, employeeId);
			
			int noOfRowsAffected = preparedStatement.executeUpdate();
			if (noOfRowsAffected != 0) {
				isEmployeeEmailIdUpdated = true;
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace();
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}

				if (connection != null) {
					connection.close();
				}
			} catch (SQLException sqlEx) {
				sqlEx.printStackTrace();
			}
		}

		return isEmployeeEmailIdUpdated;
	}
}

