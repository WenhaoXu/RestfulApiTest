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

    public employees deleteEmployees(int id) {
        List<employees>  dblist=  dbService.getEmployeesList();
        for(int i=0;i<dblist.size();i++){
            if(dblist.get(i).id==id){
                return  dblist.remove(i);
            }
        }
        return  null;

    }

    public employees updateEmployees(int id, employees  e) {
        List<employees>  list=  dbService.getEmployeesList();
        for(int i=0;i<list.size();i++){
            if(list.get(i).id==id){
                list.remove(i);
                list.add(e);
                return e;
            }
        }
        return  null;
    }
}
