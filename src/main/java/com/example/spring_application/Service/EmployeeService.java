package com.example.spring_application.Service;

import java.util.List;

import com.example.spring_application.Models.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();
	void addEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
}
