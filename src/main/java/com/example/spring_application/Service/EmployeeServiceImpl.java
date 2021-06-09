package com.example.spring_application.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring_application.Models.Employee;
import com.example.spring_application.Repository.Repository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private Repository repository;
	
	@Override
	public List<Employee> getAllEmployees() {
		System.out.print("service - " );
		System.out.print(repository.findAll());
		return repository.findAll();
	}

	@Override
	public void addEmployee(Employee employee) {
		this.repository.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional <Employee> optional = repository.findById(id);
		Employee employee = null;
		if(optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("Employee not found for id: " + id);
		}
		return employee;
	}
	
	@Override
    public void deleteEmployeeById(long id) {
        this.repository.deleteById(id);
    }

}
