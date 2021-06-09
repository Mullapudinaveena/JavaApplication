package com.example.spring_application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_application.Models.Employee;


public interface Repository extends JpaRepository<Employee, Long> {
}
