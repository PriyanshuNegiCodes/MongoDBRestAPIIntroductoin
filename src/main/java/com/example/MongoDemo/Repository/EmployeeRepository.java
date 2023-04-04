package com.example.MongoDemo.Repository;

import com.example.MongoDemo.Domain.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    List<Employee> findByDepartment(String department);    //The below code will access the nested document
//    @Query("{'address.city':{$in:[?0, ?1]}")
//    List<Employee> getEmployeeByCity(String city0, String city1);
    @Query("{'address.city':{$in:[?0]}}")
    List<Employee> getEmployeeByCity(String city);
}
