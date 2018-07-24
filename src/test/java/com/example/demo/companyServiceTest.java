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

}
