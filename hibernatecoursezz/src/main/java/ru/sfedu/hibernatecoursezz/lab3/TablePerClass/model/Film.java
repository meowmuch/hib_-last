package ru.sfedu.hibernatecoursezz.lab3.TablePerClass.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity(name = "Film_TPC")
public class Film extends InfoRes {


    private String country;


    private String year;


    private String producer;


    private String format;

    public Film() {}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(country, film.country) &&
                Objects.equals(year, film.year) &&
                Objects.equals(producer, film.producer) &&
                Objects.equals(format, film.format);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, year, producer, format);
    }

    @Override
    public String toString() {
        return "Film{" +
                ", country='" + country +
                ", year='" + year +
                ", producer='" + producer +
                ", format='" + format + '\'' +
                '}';
    }
}
