package com.example.MongoDemo.Services;

import com.example.MongoDemo.Domain.Employee;
import com.example.MongoDemo.Exception.EmployeeAlreadyExistException;

import java.util.List;

public interface IEmployeeServices {
    Employee addEmployee(Employee employee) throws EmployeeAlreadyExistException;
//    List<Employee> findEmployee();


}
