package com.example.employee;

import com.example.employee.model.Address;
import com.example.employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getById(long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(long id, Employee employee) {
        Employee existing = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        existing.setName(employee.getName());
        existing.setDepartment(employee.getDepartment());
        existing.setEmail(employee.getEmail());
        existing.setSalary(employee.getSalary());

        return employeeRepository.save(existing);
    }

    @Override
    public void delete(long id) {
        employeeRepository.deleteById(id);
    }

    // ✅ Single method for add + update address
    public Employee updateAddress(Long id, Address address) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setAddress(address);
        return employeeRepository.save(employee);
    }
}
