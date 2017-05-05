/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yiibai;

/**
 *
 * @author Maxsu
 */
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "book")
@SessionScoped
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    String bookNo;
    String productName;
    BigDecimal price;
    int qty;

    private static final Book[] bookList = new Book[]{
        new Book("1", "CSS", new BigDecimal("123.12"), 1),
        new Book("2", "HTML", new BigDecimal("321.12"), 2),
        new Book("3", "SQL", new BigDecimal("12333.33"), 8),
        new Book("4", "Javascript", new BigDecimal("1233.33"), 3),
        new Book("5", "Web", new BigDecimal("123.22"), 10)

    };

    public String getBookNo() {
        return bookNo;
    }

    public void setBookNo(String bookNo) {
        this.bookNo = bookNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    private DataModel<Book> book = new ArrayDataModel<Book>(bookList);

    public DataModel<Book> getBookList() {
        return book;
    }

    public static class Book {

        String bookNo;
        String productName;
        BigDecimal price;
        int qty;

        public Book(String bookNo, String productName,
                BigDecimal price, int qty) {
            this.bookNo = bookNo;
            this.productName = productName;
            this.price = price;
            this.qty = qty;
        }

        public String getBookNo() {
            return bookNo;
        }

        public void setBookNo(String bookNo) {
            this.bookNo = bookNo;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }
    }

}
