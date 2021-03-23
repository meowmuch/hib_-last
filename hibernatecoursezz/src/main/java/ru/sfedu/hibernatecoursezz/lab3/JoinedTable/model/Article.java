package ru.sfedu.hibernatecoursezz.lab3.JoinedTable.model;

import com.opencsv.bean.CsvBindByName;

import javax.persistence.Entity;
import java.util.Objects;

@Entity(name="Article_JT")
public class Article extends InfoRes {

    @CsvBindByName(required = true)
    private String title;

    @CsvBindByName(required = true)
    private String content;

    public Article() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) &&
                Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content);
    }

    @Override
    public String toString() {
        return "Article{" +
                "title=" + title +
                ", content='" + content + '\'' +
                '}';
    }

}
