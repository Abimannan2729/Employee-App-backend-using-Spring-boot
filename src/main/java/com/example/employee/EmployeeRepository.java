package com.example.employee;

import com.example.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee>findByEmail(String email);
    Optional<Employee> findByDepartment(String dept);
}
