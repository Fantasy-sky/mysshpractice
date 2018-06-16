package com.company.xtz.domain;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GenericGenerator(name = "myuuid",strategy = "uuid")
    @GeneratedValue(generator = "myuuid")
    private String id;
    private String address;
    private Double totalPrice;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date publicationDate;
    // 与customer表的联系多对一
    @ManyToOne(targetEntity = Customer.class)
    private Customer customer;
    // 与book表多对多关系，设置级联保存
    @ManyToMany(targetEntity = Book.class)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Set<Book> books = new HashSet<Book>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", address='" + address + '\'' +
                ", totalPrice=" + totalPrice +
                ", publicationDate=" + publicationDate +
                ", customer=" + customer +
                '}';
    }
}
