package ru.sfedu.hibernatecoursezz.lab5.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Article {

    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String title;

    @Column
    private String content;

    @ManyToMany(mappedBy = "articles")
    private List<Client> clientList;

    public Article() {};

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public List<Client> getClientList() { return clientList; }

    public void setClientList(List<Client> clientList) { this.clientList = clientList; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return id == article.id &&
                Objects.equals(title, article.title) &&
                Objects.equals(content, article.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", clientList=" + clientList +
                '}';
    }
}
