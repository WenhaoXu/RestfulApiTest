package com.example.demo.service;

import com.example.demo.DBService;
import com.example.demo.model.company;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class companyService {
    private DBService dbService;
    @Autowired
    public companyService(DBService dbService){
        this.dbService=dbService;
    }


    public  List<company> getCompanies() {
        List<company> list=   dbService.getCompanyList();
        return  list;
    }
}
