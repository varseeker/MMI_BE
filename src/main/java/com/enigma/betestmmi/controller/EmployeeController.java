package com.enigma.betestmmi.controller;

import com.enigma.betestmmi.dto.EmployeeDTO;
import com.enigma.betestmmi.entity.Employee;
import com.enigma.betestmmi.service.employee.EmployeeServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceDbImpl employeeServiceDb;

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeServiceDb.getAllData();
    }

    @PostMapping("/employee")
    public Employee create(@RequestBody EmployeeDTO employee) {
        return employeeServiceDb.createDataWithDto(employee);
    }

    @PutMapping("/employee")
    public Employee update(@RequestBody Employee employee) {
        employeeServiceDb.updateData(employee);
        return employee;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") Integer id) {
        return employeeServiceDb.getDataById(id);
    }

    @DeleteMapping("/employee/{id}")
    public void delete(@PathVariable(name = "id") Integer id) {
        employeeServiceDb.deleteData(id);
    }
}
