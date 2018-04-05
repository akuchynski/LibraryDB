package by.htp.library.dao.impl;

import static by.htp.library.dao.util.DBConnectionHelper.connect;
import static by.htp.library.dao.util.DBConnectionHelper.disconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.library.bean.Employee;
import by.htp.library.dao.EmployeeDao;

public class EmployeeDaoDBImpl implements EmployeeDao {

	private static final String SQL_CREATE_EMPLOYEE = "INSERT INTO employee (name, surname) VALUES";
	private static final String SQL_READ_EMPLOYEES = "SELECT * FROM employee";
	private static final String SQL_READ_EMPLOYEE_BY_ID = "SELECT * FROM employee WHERE emp_id = ";
	private static final String SQL_READ_EMPLOYEES_BY_SURNAME = "SELECT * FROM employee WHERE surname = ";
	private static final String SQL_UPDATE_EMPLOYEE_BY_ID = "UPDATE employee SET emp_id = emp_id + 1  WHERE emp_id = ";
	private static final String SQL_DELETE_EMPLOYEE_BY_ID = "DELETE FROM employee WHERE emp_id = ";

	public void create(Employee entity) {

		Connection connection = connect();

		try {

			Statement st = connection.createStatement();
			String name = entity.getName();
			String surname = entity.getSurname();

			st.executeUpdate(SQL_CREATE_EMPLOYEE + " ('" + name + "', '" + surname + "')");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

	}

	public List<Employee> readAll() {

		List<Employee> employees = new ArrayList<>();

		Connection connection = connect();

		try {
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_READ_EMPLOYEES);

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("emp_id"));
				employee.setName(rs.getString("name"));
				employee.setSurname(rs.getString("surname"));

				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

		return employees;
	}

	public Employee read(int id) {

		Connection connection = connect();
		Employee employee = new Employee();

		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_READ_EMPLOYEE_BY_ID + id);

			while (rs.next()) {
				employee.setId(rs.getInt("emp_id"));
				employee.setName(rs.getString("name"));
				employee.setSurname(rs.getString("surname"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

		return employee;
	}

	public List<Employee> readBySurname(String surname) {

		List<Employee> employees = new ArrayList<>();
		Connection connection = connect();

		try {
			
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(SQL_READ_EMPLOYEES_BY_SURNAME + "'" + surname + "'");

			while (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt("emp_id"));
				employee.setName(rs.getString("name"));
				employee.setSurname(rs.getString("surname"));

				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);

		return employees;
	}

	public void update(int id) {

		Connection connection = connect();

		try {

			Statement st = connection.createStatement();
			st.executeUpdate(SQL_UPDATE_EMPLOYEE_BY_ID + id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
	}

	public void delete(int id) {

		Connection connection = connect();

		try {
			Statement st = connection.createStatement();
			st.executeUpdate(SQL_DELETE_EMPLOYEE_BY_ID + id);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		disconnect(connection);
	}
}
