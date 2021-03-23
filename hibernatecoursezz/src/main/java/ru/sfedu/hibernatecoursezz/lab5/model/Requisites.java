package ru.sfedu.hibernatecoursezz.lab5.model;


import javax.persistence.*;

@Entity
@Table
public class Requisites {

    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne(mappedBy = "requisites", cascade = CascadeType.ALL)
    private Client client;

    public Requisites() {}

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Client getClient() { return client; }

    public void setClient(Client client) { this.client = client; }

    @Override
    public String toString() {
        return "Requisites{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", client=" + client +
                '}';
    }
}
