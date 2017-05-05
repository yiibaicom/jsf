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
 
@ManagedBean(name="book")
@SessionScoped
public class User implements Serializable{

  private static final long serialVersionUID = 1L;

  private static final ArrayList<Book> bookList = 
    new ArrayList<Book>(Arrays.asList(
    new Book("1", "CSS", new BigDecimal("711.00"), 1),
    new Book("2", "SQL", new BigDecimal("522.00"), 2),
    new Book("3", "Java", new BigDecimal("13333.00"), 8),
    new Book("4", "HTML", new BigDecimal("5244.00"), 3),
    new Book("5", "Web", new BigDecimal("441.00"), 10)
  ));
   
  public ArrayList<Book> getBookList() {
    return bookList;
  }
  public String deleteAction(Book book) {
    bookList.remove(book);
    return null;
  }
 
  public static class Book{
    
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