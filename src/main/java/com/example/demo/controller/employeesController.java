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
    public employees getEmployeesById(@PathVariable int id){
          employees employees=emplService.getEmployeesById(id);
         return  employees;
     }

     @GetMapping("/employees/male")
    public String getEmployeesByMale(){
         List<employees> list =emplService.getEmployeesByMale("boy");
         return null;
    }

    @GetMapping("/employees/page/{page}/pageSize/{pageSize}")
    public String getEmployeesByPage(@PathVariable int page,@PathVariable int pageSize){

         return null;
    }

    @PostMapping("/employees")
    public  employees addEmployees(@RequestBody employees empl){
            employees   employees= emplService.addEmployees(empl);
         return  employees;
    }

    @PutMapping("/employees/{id}")
    public employees updateEmployees(@PathVariable int id,@RequestBody employees employees){
         employees employees1=emplService.updateEmployees(id, employees);
         return  employees1;
    }

    @DeleteMapping ("/employees/{id}")
    public employees deleteEmployees(@PathVariable int id){
        employees employees =emplService.deleteEmployees(id);
        return  employees;
    }

}
