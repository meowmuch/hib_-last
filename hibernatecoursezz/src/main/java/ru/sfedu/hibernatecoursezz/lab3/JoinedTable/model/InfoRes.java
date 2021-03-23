package ru.sfedu.hibernatecoursezz.lab3.JoinedTable.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "INFORES_JT")
@Inheritance(strategy = InheritanceType.JOINED)
public class InfoRes implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @CsvBindByName(required = true)
  private Long id;

  @CsvBindByName(required = true)
  private String bookAuthorName;

  @CsvBindByName(required = true)
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
            ", bookAuthorName='" + bookAuthorName +
            ", nameOfBook='" + nameOfBook +
            '}';
  }

}
