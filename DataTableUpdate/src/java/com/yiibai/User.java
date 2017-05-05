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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "book")
@SessionScoped
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final ArrayList<Book> bookList
            = new ArrayList<Book>(Arrays.asList(
                    new Book("1", "CSS", new BigDecimal("722.22"), 1),
                    new Book("2", "HTML", new BigDecimal("533.33"), 2),
                    new Book("3", "Java", new BigDecimal("11444.44"), 8),
                    new Book("4", "Javascript", new BigDecimal("5255.55"), 3),
                    new Book("5", "SQL", new BigDecimal("166.66"), 10)
            ));

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public String saveAction() {
        //get all existing value but set "editable" to false 
        for (Book book : bookList) {
            book.setEditable(false);
        }
        //return to current page
        return null;
    }

    public String editAction(Book book) {
        book.setEditable(true);
        return null;
    }

    public static class Book {

        String bookNo;
        String productName;
        BigDecimal price;
        int qty;
        boolean editable;

        public Book(String bookNo, String productName, BigDecimal price, int qty) {
            this.bookNo = bookNo;
            this.productName = productName;
            this.price = price;
            this.qty = qty;
        }

        public boolean isEditable() {
            return editable;
        }

        public void setEditable(boolean editable) {
            this.editable = editable;
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
