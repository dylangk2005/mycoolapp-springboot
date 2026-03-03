package com.dylangk.springboot.cruddemo.services;

import com.dylangk.springboot.cruddemo.dao.EmployeeDAO;
import com.dylangk.springboot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServicesImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }
}
