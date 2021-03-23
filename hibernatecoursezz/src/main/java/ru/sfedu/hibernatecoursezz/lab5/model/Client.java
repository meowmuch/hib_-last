package ru.sfedu.hibernatecoursezz.lab5.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
public class Client {

    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "req_id", referencedColumnName = "id")
    private Requisites requisites;

    @Column
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Plan> planList;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "Client_ArticleS",
            joinColumns = @JoinColumn(name = "Client_id"),
            inverseJoinColumns = @JoinColumn(name = "Article_id")
    )
    private List<Article> articles;

    public Client() { }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Requisites getRequisites() { return requisites; }

    public void setRequisites(Requisites requisites) { this.requisites = requisites; }

    public List<Plan> getPlanList() { return planList; }

    public void setPlanList(List<Plan> planList) { this.planList = planList; }

    public List<Article> getArticles() { return articles; }

    public void setArticles(List<Article> articles) { this.articles = articles; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(planList, client.planList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planList);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
    //            ", requisites=" + requisites +
    //            ", planList=" + planList +
   //             ", articles=" + articles +
                '}';
    }
}
