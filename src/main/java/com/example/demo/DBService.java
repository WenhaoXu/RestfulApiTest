package com.example.demo;

import com.example.demo.model.company;
import com.example.demo.model.employees;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Component
public class DBService {
   HashMap<Integer,company> companyMap =new HashMap<>();
   List<employees> employeesList=new LinkedList<>();
    public DBService(){

    }

    public HashMap<Integer, company> getCompanyMap() {
        return companyMap;
    }

    public List<employees> getEmployeesList() {
        return employeesList;
    }
}
