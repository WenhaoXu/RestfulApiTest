package com.example.demo.controller;

import com.example.demo.model.company;
import com.example.demo.service.companyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class companyController {
    @Autowired
    private  companyService companyService;

    @GetMapping("/companies")
    public List<company> getCompanies(){
        List<company> list=companyService.getCompanies();

        return  list;
    }

    @GetMapping("/companies/{id}")
    public company getCompaniesById(@PathVariable int id){
        company company=companyService.getCompaniesById(id);

        return  company;
    }

    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    public List<company> getEmployeesByPage(@PathVariable int page, @PathVariable int pageSize){
        List<company> companies=companyService.getCompaniesByPage(page,pageSize);
        return companies;
    }

    @PostMapping("/companies")
    public  company addCompany(@RequestBody company company){
         company company1=companyService.addCompany(company);
        return  company1;
    }

    @PutMapping("/companies/{id}")
    public  company updateCompanies(@PathVariable int id,@RequestBody company company){
          company  company2 =companyService.updateCompanies(id, company);
        return company2;
    }

    @DeleteMapping("/companies/{id}")
    public company deleteCompany(@PathVariable int id){
        company company=companyService.deleteCompany(id);
        return company;
    }
}
