package ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class InfoRes {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;

  private String bookAuthorName;

  private String nameOfBook;



  public InfoRes() {}

  public Long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getBookAuthorName() {
    return bookAuthorName;
  }

  public void setBookAuthorName(String bookAuthorName) {
    this.bookAuthorName = bookAuthorName;
  }

  public String getNameOfBook() {
    return nameOfBook;
  }

  public void setNameOfBook(String nameOfBook) {
    this.nameOfBook = nameOfBook;
  }

  @Override
  public String toString() {
    return "InfoRes{" +
            "id=" + id +
            ", bookAuthorName='" + bookAuthorName + '\'' +
            ", nameOfBook='" + nameOfBook + '\'' +
            '}';
  }
}
