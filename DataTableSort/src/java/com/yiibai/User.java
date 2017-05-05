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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "book")
@SessionScoped
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Book> bookArrayList;

    private boolean sortAscending = true;

    private static final Book[] bookList = {
        new Book("1234", "Java", new BigDecimal("2303.0"), 3),
        new Book("3211", "Web", new BigDecimal("4232.00"), 6),
        new Book("2344", "SQL", new BigDecimal("5230.00"), 10),
        new Book("5643", "CSS", new BigDecimal("11320.00"), 9),
        new Book("4565", "HTML", new BigDecimal("232.00"), 20)
    };

    public User() {

        bookArrayList = new ArrayList<Book>(Arrays.asList(bookList));

    }

    public List<Book> getBookList() {

        return bookArrayList;

    }

    //sort by book no
    public String sortByBookNo() {
        if (sortAscending) {
            //ascending book
            Collections.sort(bookArrayList, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getBookNo().compareTo(o2.getBookNo());
                }
            });
            sortAscending = false;
        } else {
            //descending book
            Collections.sort(bookArrayList, new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o2.getBookNo().compareTo(o1.getBookNo());
                }
            });
            sortAscending = true;
        }
        return null;
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
