package com.example.demo;

import com.example.demo.model.employees;
import com.example.demo.service.employeesService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedList;
import java.util.List;




//@RunWith(SpringRunner.class)
@SpringBootTest
public  class employeesServiceTest {


//        @Before
//        public void setUp(){

//    }

    @Test
    public void should_Return_EmployeesList_When_getEmployees(){
        DBService dbService= Mockito.mock( DBService.class);
        employeesService employeesService=new employeesService(dbService);
        List<employees> list=new LinkedList<>();
        employees employees1=new employees();
        list.add(employees1);
        Mockito.when(dbService.getEmployeesList()).thenReturn(list);
        List<employees> list1= employeesService.getEmployeesList();
        Assertions.assertThat(list1.size()).isEqualTo(1);
    }

    @Test
    public void should_Return_Employees_When_addEmployees(){
        DBService dbService= Mockito.mock( DBService.class);
        employeesService employeesService=new employeesService(dbService);
        List<employees> list=new LinkedList<>();
        employees employees1=new employees();
        Mockito.when(dbService.getEmployeesList()).thenReturn(list);
//        Mockito.when(dbService.getEmployeesList()).thenReturn(list);
       employees employees= employeesService.addEmployees(employees1);
        Assertions.assertThat(employees).isEqualTo(employees1);
    }

    @Test
    public void should_Return_Employees_When_getEmployeesByID(){
        DBService dbService= Mockito.mock( DBService.class);
        employeesService employeesService=new employeesService(dbService);
        List<employees> list=new LinkedList<>();
        Mockito.when(dbService.getEmployeesList()).thenReturn(list);
        employees employees= employeesService.getEmployeesById(1);
        Assertions.assertThat(employees).isEqualTo(null);
    }

    @Test
    public void should_Return_EmployeesList_When_getEmployeesByMale(){
        DBService dbService= Mockito.mock( DBService.class);
        employeesService employeesService=new employeesService(dbService);
        List<employees> list=new LinkedList<>();
        Mockito.when(dbService.getEmployeesList()).thenReturn(list);
        List<employees> list1= employeesService.getEmployeesByMale("boy");
        Assertions.assertThat(list1).isEqualTo(null);
    }
}
