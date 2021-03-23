package ru.sfedu.hibernatecoursezz.lab5.model;


import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;

@Entity
@Table
public class Book {

    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String nameOfBook;

    @Column
    private String authorName;

    public Book () {}

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNameOfBook() { return nameOfBook; }

    public void setNameOfBook(String nameOfBook) { this.nameOfBook = nameOfBook; }

    public String getAuthorName() { return authorName; }

    public void setAuthorName(String authorName) { this.authorName = authorName; }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameOfBook='" + nameOfBook + '\'' +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}