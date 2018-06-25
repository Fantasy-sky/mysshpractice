package com.company.xtz.dao.impl;

import com.company.xtz.dao.IProductDAO;
import com.company.xtz.domain.Order;
import com.company.xtz.utils.SessionFactoryUtils;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("iProductDAO")
public class ProductDAOImpl implements IProductDAO {
    public ProductDAOImpl() {
    }

    @Override
    public void addOrder(Order order) {
        // 获取数据库操作对象
        Session session = SessionFactoryUtils.getCurrentSession();
        // 开启事务
        session.beginTransaction();

        // 添加保存一条订单记录
        session.save(order);
       // int i = 0/0;
        // 提交事务
        session.getTransaction().commit();

    }
}
