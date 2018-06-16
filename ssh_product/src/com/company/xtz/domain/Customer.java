package com.company.xtz.domain;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_customer")
@BatchSize(size = 5)
public class Customer {
    @Id
    @GenericGenerator(name = "myuuid",strategy = "uuid")
    @GeneratedValue(generator = "myuuid")
    private String id;
    @Column(name = "name",length = 30)
    private String name;

    // Order方维护外键，设置孤值删除
    @OneToMany(targetEntity = Order.class,mappedBy = "customer",orphanRemoval = true)
    // 设置级联
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @BatchSize(size = 5)
    private Set<Order> orders = new HashSet<Order>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 不进行json转换
    @JSON(serialize = false)
    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
