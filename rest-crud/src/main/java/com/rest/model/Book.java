package com.rest.model;

import java.util.Date;

public class Book {
    private int Id;
    private String Title;
    private Date Date;
    
    public Book(int Id, String Title, Date Date) {
        this.Id = Id;
        this.Title = Title;
        this.Date = Date;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }
    
}
