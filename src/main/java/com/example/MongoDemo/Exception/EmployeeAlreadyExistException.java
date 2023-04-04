package com.example.MongoDemo.Exception;

import org.bson.types.Code;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.CONFLICT, reason = "Employee with this EmpId is already available")
public class EmployeeAlreadyExistException extends Exception{

}
