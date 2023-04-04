package com.example.MongoDemo.Services;

import com.example.MongoDemo.Domain.Employee;
import com.example.MongoDemo.Exception.EmployeeAlreadyExistException;
import com.example.MongoDemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServices implements IEmployeeServices{

   EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistException {
        if(employeeRepository.findById(employee.getEmpId()).isEmpty()){
            return employeeRepository.insert(employee);
        }else {
            throw new EmployeeAlreadyExistException();
        }
//        return employeeRepository.insert(employee);
    }
}
