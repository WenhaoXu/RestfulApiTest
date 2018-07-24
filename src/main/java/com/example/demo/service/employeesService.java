package com.example.demo.service;

import com.example.demo.DBService;
import com.example.demo.model.employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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
        List<employees>newlist= dblist.stream().filter(x->x.sex.equals(boy)).collect(Collectors.toList());
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

    public List<employees> getEmployeesByPage(int page, int pageSize) {
        List<employees>  list=  dbService.getEmployeesList();
        List<employees>newlist=new LinkedList<>();
        int  pages=0;
        if(list.size()%pageSize!=0)
        {  pages=list.size()/pageSize+1; }
        else {
            pages=list.size()/pageSize;
        }
        if(pages<page){
            return null;
        }
        else{
            for(int i=(page-1)*pageSize;i<=pageSize&&i<page*pageSize;i++){
                newlist.add(list.get(i));
            }
            return  newlist;
        }
    }
}
