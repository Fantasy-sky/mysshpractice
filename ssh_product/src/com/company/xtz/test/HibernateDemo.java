package com.company.xtz.test;


import com.company.xtz.domain.Customer;
import com.company.xtz.domain.Order;
import com.company.xtz.utils.SessionFactoryUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class HibernateDemo {
    private Session session;

    // 每次代码测试都会执行
    @Before
    public void init() {
        session = SessionFactoryUtils.getCurrentSession();
        session.beginTransaction();
    }

    // 每次代码测试部分结束都会执行
    @After
    public void showDown() {
        session.getTransaction().commit();
    }

    @Test
    public void test1() {
        Customer customer1 = new Customer();
        customer1.setName("小小");
        Customer customer2 = new Customer();
        customer2.setName("天天");
        Customer customer3 = new Customer();
        customer3.setName("鹅鹅");
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        order1.setTotalPrice(200d);
        order2.setTotalPrice(250d);
        order3.setTotalPrice(300d);

        customer1.getOrders().add(order1);
        customer1.getOrders().add(order2);
        customer2.getOrders().add((order3));


        order1.setCustomer(customer1);
        order2.setCustomer(customer1);
        order3.setCustomer(customer2);

        // 级联保存
        session.save(customer1);
        session.save(customer2);
        session.save(customer3);
    }
    @Test
    public void test2(){
        // 迫切左外连接
        Query query = session.createQuery("select distinct c from Customer c left join fetch c.orders where name = '天天'");
        List<Customer> list = query.list();
        for (Customer customer : list) {
            System.out.println(customer);
            System.out.println(customer.getOrders());
        }
        // 隐式内连接
        Query query1 = session.createQuery("from Customer c ,Order o where c = o.customer");
        List list1 = query1.list();


       /* Book book1 = new Book();
        Book book2 = new Book();
        Book book3 = new Book();
        book1.setName("Think In Java");
        book2.setName("Effictive Java");
        book3.setName("clear code");

        order1.getBooks().add(book3);
        order1.getBooks().add(book2);

        order2.getBooks().add(book1);
        order2.getBooks().add(book3);

        book1.getOrders().add(order2);
        book2.getOrders().add(order1);
        book3.getOrders().add(order1);
        book3.getOrders().add(order2);

        session.save(order1);
        session.save(order2);
        session.save(order3);
*/
    }

    /**
     * 孤值删除
     */
    @Test
    public void test3(){
        Query query = session.createQuery("select distinct c from Customer c left join fetch c.orders where name = '小小'");

        List<Customer> list = query.list();
        System.out.println(list.get(0));
        for (Customer customer : list) {
            System.out.println(customer);
            System.out.println(customer.getOrders());
        }
        Query from_order = session.createQuery("from Order o where o.Order");
        Order o = (Order)from_order.list().get(1);
        System.out.println(o);
        // 移除掉用户的一个订单
        System.out.println(list.get(0).getOrders().remove(o));

    }



}
