package com.example.MongoDemo.Services;

import com.example.MongoDemo.Domain.Employee;
import com.example.MongoDemo.Exception.EmployeeAlreadyExistException;
import com.example.MongoDemo.Exception.EmployeeNotFoundExceptoin;
import com.example.MongoDemo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmpById(int id) throws EmployeeNotFoundExceptoin{

        if(employeeRepository.findById(id).isEmpty()){
            return employeeRepository.findById(id).get();

        }else{
            throw new EmployeeNotFoundExceptoin();
        }

    }

    @Override
    public Employee updateEmployee(Employee employee, int id) throws EmployeeNotFoundExceptoin {
        if(employeeRepository.findById(id).isEmpty()){
            throw new EmployeeNotFoundExceptoin();
        }else{
            return employeeRepository.save(employee);
        }
    }

    @Override
    public boolean deleteEmp(int id) {
        return false;
    }

    @Override
    public List<Employee> getEmpByDepartment(String deptName) {
        return employeeRepository.findByDepartment(deptName);
    }
}
