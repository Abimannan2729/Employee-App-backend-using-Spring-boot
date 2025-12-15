package com.example.employee;

import com.example.employee.model.Address;
import com.example.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);
    Optional<Employee> getById(long id);
    List<Employee> getAll();
    Employee update(long id,Employee employee);
    void delete(long id);

    Employee updateAddress(Long id, Address address);
}
