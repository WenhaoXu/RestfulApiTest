package com.example.demo.controller;

import com.example.demo.model.employees;
import com.example.demo.service.employeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class employeesController {
     @Autowired
    private employeesService emplService;


     @GetMapping("/employees")
    public  List<employees>  getEmployeesList(){
        List<employees>list= emplService.getEmployeesList();

        return list;
     }

     @GetMapping("/employees/{id}")
    public String getEmployeesById(@PathVariable int id){

         return  null;
     }

     @GetMapping("/employees/male")
    public String getEmployeesByMale(){

         return null;
    }

    @GetMapping("/employees/page/{page}/pageSize/{pageSize}")
    public String getEmployeesByPage(@PathVariable int page,@PathVariable int pageSize){

         return null;
    }

    @PostMapping("/employees")
    public  String addEmployees(@RequestBody employees empl){

         return  null;
    }

    @PutMapping("/employees/{id}")
    public String updateEmployees(@PathVariable int id){

         return  null;
    }

    @DeleteMapping ("/employees/{id}")
    public String deleteEmployees(@PathVariable int id){

        return  null;
    }

}
