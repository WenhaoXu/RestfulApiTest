package com.example.demo.service;

import com.example.demo.DBService;
import com.example.demo.model.company;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

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

    public company getCompaniesById(int id) {
        List<company> list=   dbService.getCompanyList();
        List<company>newlist= list.stream().filter(x->x.id==id).collect(Collectors.toList());
        if(newlist.size()==0){
            return  null;
        }
        else {
            return  newlist.get(0);
        }
    }
}
