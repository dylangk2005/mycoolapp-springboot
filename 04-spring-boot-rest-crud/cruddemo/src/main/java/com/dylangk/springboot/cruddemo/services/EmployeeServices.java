package com.dylangk.springboot.cruddemo.services;

import com.dylangk.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> findAll();

}
