package com.enigma.betestmmi.service.employee;

import com.enigma.betestmmi.dto.EmployeeDTO;
import com.enigma.betestmmi.entity.Employee;
import com.enigma.betestmmi.entity.Position;
import com.enigma.betestmmi.repo.EmployeeRepo;
import com.enigma.betestmmi.service.position.PositionServiceDbImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceDbImpl implements EmployeeService{

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    PositionServiceDbImpl positionServiceDb;

    @Override
    public Employee getDataById(Integer id) {
        return employeeRepo.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllData() {
        return employeeRepo.getAllEmployee();
    }

    @Override
    public Employee createData(Employee employee) {
        return employeeRepo.addEmployee(employee);
    }

    public Employee createDataWithDto(EmployeeDTO employeeDTO) {
        Position position = positionServiceDb.getDataById(employeeDTO.getPositionId());
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getBirthDate(), position, employeeDTO.getIdNumber(), employeeDTO.getGender(), employeeDTO.getIsDelete());
        return employeeRepo.addEmployee(employee);
    }

    @Override
    public void deleteData(Integer id) {
        employeeRepo.deleteEmployeeById(id);
    }

    @Override
    public Employee updateData(Employee employee) {
        return employeeRepo.updateEmployee(employee);
    }
}
