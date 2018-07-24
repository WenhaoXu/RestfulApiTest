package com.example.demo;

import com.example.demo.model.company;
import com.example.demo.service.companyService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedList;
import java.util.List;

@SpringBootTest
public class companyServiceTest {

    @Test
    public void should_Return_EmployeesList_When_getEmployees(){
        DBService dbService= Mockito.mock( DBService.class);
        companyService companyService=new companyService(dbService);
        List<company> list=new LinkedList<>();
        company company=new company();
        list.add(company);
        Mockito.when(dbService.getCompanyList()).thenReturn(list);
        List<company> list1= companyService.getCompanies();
        Assertions.assertThat(list1.size()).isEqualTo(1);
    }


    @Test
    public void should_Return_Employees_When_getEmployeesById(){
        DBService dbService= Mockito.mock( DBService.class);
        companyService companyService=new companyService(dbService);
        List<company> list=new LinkedList<>();
        company company=new company();
        list.add(company);
        Mockito.when(dbService.getCompanyList()).thenReturn(list);
        company company1= companyService.getCompaniesById(1);
        Assertions.assertThat(company1).isEqualTo(null);
    }

    @Test
    public void should_Return_EmployeesList_When_getEmployeesByPage(){
        DBService dbService= Mockito.mock( DBService.class);
        companyService companyService=new companyService(dbService);
        List<company> list=new LinkedList<>();
        company company=new company();
//        list.add(company);
        Mockito.when(dbService.getCompanyList()).thenReturn(list);
        List<company> list1= companyService.getCompaniesByPage(1,1);
        Assertions.assertThat(list1).isEqualTo(null);
    }


    @Test
    public void should_Return_Employees_When_addEmployees(){
        DBService dbService= Mockito.mock( DBService.class);
        companyService companyService=new companyService(dbService);
        List<company> list=new LinkedList<>();
        company company=new company();
        Mockito.when(dbService.getCompanyList()).thenReturn(list);
        company company1= companyService.addCompany(company);
        Assertions.assertThat(company1).isEqualTo(company);
    }

    @Test
    public void should_Return_Employees_When_updateEmployees(){
        DBService dbService= Mockito.mock( DBService.class);
        companyService companyService=new companyService(dbService);
        List<company> list=new LinkedList<>();
        company company=new company();
        Mockito.when(dbService.getCompanyList()).thenReturn(list);
        company company1= companyService.updateCompanies(1,company);
        Assertions.assertThat(company1).isEqualTo(null);
    }

    @Test
    public void should_Return_Employees_When_deleteEmployees(){
        DBService dbService= Mockito.mock( DBService.class);
        companyService companyService=new companyService(dbService);
        List<company> list=new LinkedList<>();
        company company=new company();
        Mockito.when(dbService.getCompanyList()).thenReturn(list);
        company company1= companyService.deleteCompany(1);
        Assertions.assertThat(company1).isEqualTo(null);
    }
}
