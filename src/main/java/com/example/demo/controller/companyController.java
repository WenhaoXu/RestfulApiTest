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
    public List<company> getCompaniesById(){


        return  null;
    }

    @GetMapping("/companies/page/{page}/pageSize/{pageSize}")
    public List<company> getEmployeesByPage(@PathVariable int page, @PathVariable int pageSize){

        return null;
    }

    @PostMapping("/companies")
    public  company addCompany(@RequestBody company company){

        return  null;
    }

    @PutMapping("/companies/{id}")
    public  company updateCompanies(@PathVariable int id){

        return null;
    }

    @DeleteMapping("/companies/{id}")
    public company deleteCompany(@PathVariable int id){

        return null;
    }
}
