package com.ach20raf.back.service;

import com.ach20raf.back.exception.UserNotFoundException;
import com.ach20raf.back.model.Employee;
import com.ach20raf.back.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo)
    {
        this.employeeRepo=employeeRepo;
    }

    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees()
    {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id)
    {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("employee by id " + id + " was not found"));
    }

    @Query("delete from Employee e where e.id = :id")
    //this @Transactional is important when using custom transactions method created by you in the repository
    @Transactional
    public void deleteEmployee(Long id){
        System.out.println(id);
        employeeRepo.deleteEmployeeById(id);
    }

}
