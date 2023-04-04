package com.example.MongoDemo.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Employee {
    @Id //this will override the Id field that the mongo creates
    private int empId;
    private String firstName;
    private String lastName;
    private String department;
    private Address address;
}