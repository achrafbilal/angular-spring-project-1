package com.ach20raf.back;

import com.ach20raf.back.model.Employee;
import com.ach20raf.back.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Employee>>  getAllEmployees()
    {
        List<Employee>employees=employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find{id}")
    public ResponseEntity<Employee>  getEmployeeByID(@PathVariable("id") Long id)
    {
        Employee employee=employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.FOUND);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        Employee newEmployee1=employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee1,HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        Employee previousEmployee=employeeService.updateEmployee(employee);
        return new ResponseEntity<>(previousEmployee,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
