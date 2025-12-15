package com.example.employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);
    Optional<Object> getById(long id);
    List<Employee> getAll();
    Employee update(long id,Employee employee);
    void delete(long id);
}
