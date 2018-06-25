package com.company.xtz.service.impl;

import com.company.xtz.dao.IProductDAO;
import com.company.xtz.dao.ITestDAO;
import com.company.xtz.dao.impl.TestDAOImpl;
import com.company.xtz.domain.Order;
import com.company.xtz.service.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("iProductService")
@Transactional
public class ProductServiceImpl implements IProductService {
    private IProductDAO iProductDAO;

    public ProductServiceImpl() {
        System.out.println("0");
    }

    public ProductServiceImpl(IProductDAO iProductDAO) {
        System.out.println("1");
        this.iProductDAO = iProductDAO;
    }

    // @Autowired
    // @Qualifier("iProductDAO")
    @Resource(name = "iProductDAO")
    public void setIProductDAO(IProductDAO iProductDAO) {
        System.out.println("set");
        this.iProductDAO = iProductDAO;
    }
    // @Value

    @Override
    public void addOrder(Order order) {
        iProductDAO.addOrder(order);
    }

    // 传播事务测试

    private ITestDAO iTestDAO;

    @Autowired
    @Qualifier("testDao2")
    public void setTestDAO(ITestDAO testDAO) {
        this.iTestDAO = testDAO;
    }

    @Override
    public void create() {
        iTestDAO.create();
        int i = 0 / 0;

    }

    @PostConstruct
    public void myInit() {
        System.out.println("初始化");
    }

    @PreDestroy
    public void myDestroy() {
        System.out.println("对象销毁");
    }


}
