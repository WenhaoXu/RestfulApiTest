package com.example.demo.service;

import com.example.demo.DBService;
import com.example.demo.model.employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeesService {
    private DBService dbService;
    @Autowired
    public employeesService(DBService dbService){
        this.dbService=dbService;
    }

    public List<employees> getEmployeesList(){
        List<employees>  dblist=  dbService.getEmployeesList();


        return   dblist;
    };

}
