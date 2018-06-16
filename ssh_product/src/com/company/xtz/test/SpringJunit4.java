package com.company.xtz.test;

import com.company.xtz.domain.Order;
import com.company.xtz.service.IProductService;
import org.apache.struts2.ServletActionContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpringJunit4 {

    @Autowired
    private IProductService iProductService;

    @Test
    public void test(){
        iProductService.addOrder(new Order());
        System.out.println(iProductService);
    }

}

