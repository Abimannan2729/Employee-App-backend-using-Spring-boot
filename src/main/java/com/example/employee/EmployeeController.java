package com.example.employee;
import com.example.employee.model.Address;
import com.example.employee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String health() {
        return "Health ok";
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return (Employee) service.getById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return "Employee deleted successfully";
    }

    // ✅ SINGLE address API
    @PutMapping("/{id}/address")
    public Employee saveOrUpdateAddress(@PathVariable Long id,
                                        @RequestBody Address address) {
        return service.updateAddress(id, address);
    }
}
