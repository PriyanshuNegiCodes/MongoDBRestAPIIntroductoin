package com.example.MongoDemo.Controller;

import com.example.MongoDemo.Domain.Employee;
import com.example.MongoDemo.Exception.EmployeeAlreadyExistException;
import com.example.MongoDemo.Services.IEmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/Employee/v1")
public class EmployeeController {
    IEmployeeServices iEmployeeServices;

    @Autowired
    public EmployeeController(IEmployeeServices iEmployeeServices) {
        this.iEmployeeServices = iEmployeeServices;
    }

    @PostMapping("/addEmp")
    public ResponseEntity addEmployee(Employee employee) throws EmployeeAlreadyExistException {
        try{
            return new ResponseEntity(iEmployeeServices.addEmployee(employee), HttpStatus.CREATED);
        }catch (EmployeeAlreadyExistException exception){
            throw exception;
        }
    }

    @GetMapping("/getEmps")
    public ResponseEntity getEmployees(){
        return new ResponseEntity(iEmployeeServices.getEmployees(), HttpStatus.OK);
    }
    @PostMapping ("/deleteEmp/{aa}")
    public ResponseEntity deleteData(@PathVariable int aa){
        return new ResponseEntity(iEmployeeServices.deleteEmp(aa), HttpStatus.OK);
    }
    @GetMapping("/getEmpDept/{dept}")
    public ResponseEntity empByDept(@PathVariable String dept){
        return new ResponseEntity(iEmployeeServices.getEmpByDepartment(dept), HttpStatus.OK);
    }
}
