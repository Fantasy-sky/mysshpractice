package com.company.xtz.service.impl;

import com.company.xtz.dao.IProductDAO;
import com.company.xtz.domain.Order;
import com.company.xtz.service.IProductService;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Service("iProductService")
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
        //IProductDAO iProductDAO = new ProductDAOImpl();
        iProductDAO.addOrder(order);
    }

    @PostConstruct
    public void myInit(){
        System.out.println("初始化");
    }

    @PreDestroy
    public void myDestroy(){
        System.out.println("对象销毁");
    }


}
