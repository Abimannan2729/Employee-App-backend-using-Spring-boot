package com.example.employee;
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
    public String health(){
        return "Health ok";
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee){
    return service.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Object> getEmployeeById(@PathVariable Long id) {
        return service.getById(id);
    }

    // 4 UPDATE Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee) {
        return service.update(id, employee);
    }

    //  DELETE Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return "Employee deleted successfully";
    }
}
