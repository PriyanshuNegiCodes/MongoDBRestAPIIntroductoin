package com.example.MongoDemo.Services;

import com.example.MongoDemo.Domain.Employee;
import com.example.MongoDemo.Exception.EmployeeAlreadyExistException;
import com.example.MongoDemo.Exception.EmployeeNotFoundExceptoin;

import java.util.List;

public interface IEmployeeServices {
    Employee addEmployee(Employee employee) throws EmployeeAlreadyExistException;
    List<Employee> getEmployees();

    Employee getEmpById(int id) throws EmployeeNotFoundExceptoin;

    Employee updateEmployee(Employee employee, int id) throws EmployeeNotFoundExceptoin;
    boolean deleteEmp(int id);
    List<Employee> getEmpByDepartment(String deptName);
    List<Employee> getEmpCity(String city);
}
