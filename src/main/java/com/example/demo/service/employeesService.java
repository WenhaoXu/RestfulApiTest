package com.example.demo.service;

import com.example.demo.DBService;
import com.example.demo.model.employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public employees addEmployees(employees empl) {
        List<employees>  dblist=  dbService.getEmployeesList();
        dblist.add(empl);
        return empl;
    }

    public employees getEmployeesById(int id) {
        List<employees>  dblist=  dbService.getEmployeesList();
       List<employees>newlist= dblist.stream().filter(x->x.id==id).collect(Collectors.toList());
       if(newlist.size()==0){
           return  null;
       }
       else {
           return  newlist.get(0);
       }
    }

    public List<employees> getEmployeesByMale(String boy) {
        List<employees>  dblist=  dbService.getEmployeesList();
        List<employees>newlist= dblist.stream().filter(x->x.sex==boy).collect(Collectors.toList());
        if(newlist.size()==0){
            return  null;
        }
        else {
            return  newlist;
        }
    }
}
