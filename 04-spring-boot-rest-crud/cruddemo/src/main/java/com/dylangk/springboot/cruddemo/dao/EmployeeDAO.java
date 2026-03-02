package com.dylangk.springboot.cruddemo.dao;

import com.dylangk.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
