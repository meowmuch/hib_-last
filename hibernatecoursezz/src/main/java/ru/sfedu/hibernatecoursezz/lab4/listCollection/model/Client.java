package ru.sfedu.hibernatecoursezz.lab4.listCollection.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "List")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long clientId;


    private String cname;


    private String login;


    private String password;


    @ElementCollection
    @OrderColumn
    @CollectionTable(name="comment_list")
    private List<String> comment;

    public Client() {}

    public long getId() {
        return clientId;
    }

    public void setId(long clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return cname;
    }

    public void setName(String name) {
        this.cname = name;
    }

    public String getLogin() { return login; }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }

    public List<String> getComment() {
        return comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId &&
                Objects.equals(cname, client.cname) &&
                Objects.equals(login, client.login) &&
                Objects.equals(password, client.password) &&
                Objects.equals(comment, client.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, cname, login, password, comment);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", cname='" + cname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", comment=" + comment +
                '}';
    }
}
