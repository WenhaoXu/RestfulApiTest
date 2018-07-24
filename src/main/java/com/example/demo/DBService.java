package com.example.demo;

import com.example.demo.model.company;
import com.example.demo.model.employees;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class DBService {
   List<company> companyList =new LinkedList<>();
   List<employees> employeesList=new LinkedList<>();
    public DBService(){

    }

    public List<company> getCompanyList() {
        return companyList;
    }

    public List<employees> getEmployeesList() {
        return employeesList;
    }
}
