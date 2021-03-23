package ru.sfedu.hibernatecoursezz.lab4.componentCollection.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity(name = "CompColl")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long clientId;

    private String cname;

    private String login;

    private String password;

    @ElementCollection
    @CollectionTable(name = "Plan_Client")
    @AttributeOverride(
            name = "pname",
            column = @Column(name = "Plan_Name", nullable = false)
    )
    private List<Plan> plan;


    public Client() { }

    public Long getId() { return clientId; }

    public void setId(long clientId) { this.clientId = clientId; }

    public String getName() { return cname; }

    public void setName(String cname) { this.cname = cname; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<Plan> getPlans() { return plan; }

    public void setPlans(List<Plan> plan) { this.plan = plan; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return clientId == client.clientId &&
                Objects.equals(cname, client.cname) &&
                Objects.equals(login, client.login) &&
                Objects.equals(password, client.password) &&
                Objects.equals(plan, client.plan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, cname, login, password, plan);
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", cname='" + cname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", plan=" + plan +
                '}';
    }
}
