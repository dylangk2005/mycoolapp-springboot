package com.dylangk.springboot.cruddemo.services;

import com.dylangk.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeServices {
    List<Employee> findAll();
    Employee findById(int id);
    Employee save(Employee employee);
    void deleteById(int id);
}
