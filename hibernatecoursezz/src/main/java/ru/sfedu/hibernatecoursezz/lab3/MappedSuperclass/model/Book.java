package ru.sfedu.hibernatecoursezz.lab3.MappedSuperclass.model;


import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "Book1")
public class Book extends InfoRes {

    private String link;

    private String review;

    private String genre;

    private Integer timeReading;




    public Book () {}
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Integer getTimeReading() {
        return timeReading;
    }

    public void setTimeReading(Integer timeReading) {
        this.timeReading = timeReading;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


    @Override
    public String toString() {
        return "Book{" +
                "link='" + link + '\'' +
                ", review='" + review + '\'' +
                ", genre='" + genre + '\'' +
                ", timeReading=" + timeReading +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(link, book.link) &&
                Objects.equals(review, book.review) &&
                Objects.equals(genre, book.genre) &&
                Objects.equals(timeReading, book.timeReading);
    }

    @Override
    public int hashCode() {
        return Objects.hash(link, review, genre, timeReading);
    }
}
