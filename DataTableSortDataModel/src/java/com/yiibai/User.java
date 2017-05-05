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
import java.util.Comparator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;
import java.util.Arrays;
import java.util.Comparator;
import javax.faces.model.DataModel;

@ManagedBean(name = "book")
@SessionScoped
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private SortableDataModel<Book> sotableDataModel;

    private boolean sortAscending = true;

    private static final Book[] bookList = {
        new Book("1", "CSS", new BigDecimal("1500.00"), 3),
        new Book("2", "HTML", new BigDecimal("421.00"), 6),
        new Book("3", "Java", new BigDecimal("5222.00"), 10),
        new Book("4", "Javascript", new BigDecimal("1111.00"), 9),
        new Book("5", "SQL", new BigDecimal("211.00"), 20)
    };

    public User() {
        sotableDataModel = new SortableDataModel<Book>(new ArrayDataModel<Book>(bookList));

    }

    public DataModel<Book> getBookList() {

        return sotableDataModel;

    }

    //sort by book no
    public String sortByBookNo() {
        if (sortAscending) {
            sotableDataModel.sortBy(new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o1.getBookNo().compareTo(o2.getBookNo());
                }
            });
            sortAscending = false;
        } else {
            //descending book
            sotableDataModel.sortBy(new Comparator<Book>() {
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

class SortableDataModel<E> extends DataModel<E> {

    DataModel<E> model;
    private Integer[] rows;

    SortableDataModel(DataModel<E> model) {
        this.model = model;
        initRows();
    }

    public void initRows() {
        int rowCount = model.getRowCount();
        if (rowCount != -1) {
            this.rows = new Integer[rowCount];
            for (int i = 0; i < rowCount; ++i) {
                rows[i] = i;
            }
        }
    }

    public void sortBy(final Comparator<E> comparator) {
        Comparator<Integer> rowComp = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                E o1 = getData(i1);
                E o2 = getData(i2);
                return comparator.compare(o1, o2);
            }
        };
        Arrays.sort(rows, rowComp);

    }

    private E getData(int row) {
        int originalRowIndex = model.getRowIndex();

        model.setRowIndex(row);
        E newRowData = model.getRowData();
        model.setRowIndex(originalRowIndex);

        return newRowData;
    }

    @Override
    public void setRowIndex(int rowIndex) {

        if (0 <= rowIndex && rowIndex < rows.length) {
            model.setRowIndex(rows[rowIndex]);
        } else {
            model.setRowIndex(rowIndex);
        }
    }

    @Override
    public boolean isRowAvailable() {
        return model.isRowAvailable();
    }

    @Override
    public int getRowCount() {
        return model.getRowCount();
    }

    @Override
    public E getRowData() {
        return model.getRowData();
    }

    @Override
    public int getRowIndex() {
        return model.getRowIndex();
    }

    @Override
    public Object getWrappedData() {
        return model.getWrappedData();
    }

    @Override
    public void setWrappedData(Object data) {

        model.setWrappedData(data);
        initRows();

    }

}
