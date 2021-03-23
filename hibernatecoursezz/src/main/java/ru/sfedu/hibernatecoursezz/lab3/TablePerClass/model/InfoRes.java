package ru.sfedu.hibernatecoursezz.lab3.TablePerClass.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "InfoRes_TPC")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class InfoRes implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
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





}
