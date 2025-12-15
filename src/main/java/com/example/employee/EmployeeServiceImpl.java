package com.example.employee;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository=employeeRepository;
    }
    @Override
    public Employee save(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Optional<Object> getById(long id) {
        employeeRepository.findById(id);
        return Optional.empty();
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee update(long id, Employee employee) {
        Employee exisiting = employeeRepository.findById(id).orElse(null);
        if(exisiting!=null){
            exisiting.setName(employee.getName());
            exisiting.setDepartment(employee.getDepartment());
            exisiting.setEmail(employee.getEmail());
            exisiting.setSalary(employee.getSalary());
            employeeRepository.save(exisiting);
        }
        return null;
    }

    @Override
    public void delete(long id) {
    employeeRepository.deleteById(id);
    }
}
