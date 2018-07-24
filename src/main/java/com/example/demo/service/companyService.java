package com.example.demo.service;

import com.example.demo.DBService;
import com.example.demo.model.company;
import com.example.demo.model.employees;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
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

    public List<company> getCompaniesByPage(int page, int pageSize) {
        List<company>  list=  dbService.getCompanyList();
        List<company>newlist=new LinkedList<>();
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


    public company addCompany(company company) {
        List<company>  list=  dbService.getCompanyList();
        list.add(company);
        return company;

    }


    public company updateCompanies(int id, company company) {
        List<company>  list=  dbService.getCompanyList();
        List<employees>  list2=  dbService.getEmployeesList();
        for(int i=0;i<list.size();i++){
            if(list.get(i).id==id){
                list.remove(i);
                list.add(company);
                for(int j=0;i<list2.size();j++){
                    if(list2.get(i).getCompany().id==id){
                        list2.get(i).setCompany(company);
                    }
                }
                return company;
            }
        }
        return  null;


    }

    public company deleteCompany(int id) {




        return  null;
    }
}
