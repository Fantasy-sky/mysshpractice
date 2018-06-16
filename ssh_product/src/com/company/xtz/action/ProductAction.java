package com.company.xtz.action;


import com.alibaba.fastjson.JSONObject;

import com.company.xtz.domain.Order;
import com.company.xtz.service.IProductService;
import com.company.xtz.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import com.opensymphony.xwork2.ModelDriven;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.ApplicationContext;

import org.springframework.web.context.WebApplicationContext;


import java.io.IOException;

@Namespace("/")
@ParentPackage("struts-default")
public class ProductAction extends ActionSupport implements ModelDriven<Order> {

    private Order order = new Order();

    @Override
    public Order getModel() {
        return order;
    }

    // results = {@Result(name = "success",type = "redirect",location = "add.jsp")
    @Action(value = "product_add")
    public void addOrder() {
        try {
            ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
            ApplicationContext applicationContext = (ApplicationContext) ServletActionContext.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
            IProductService iProductService = (ProductServiceImpl) applicationContext.getBean("iProductService");
            iProductService.addOrder(order);


            String jsonString = JSONObject.toJSONString("你好");
            ServletActionContext.getResponse().getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
