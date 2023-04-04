package com.example.MongoDemo.Services;

import com.example.MongoDemo.Domain.Employee;

import java.util.List;

public interface IEmployeeServices {
    Employee insertEmployee(Employee employee);
    List<Employee> findEmployee();

}
