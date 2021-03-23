package ru.sfedu.hibernatecoursezz.lab5.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table
public class Plan {

    @Id
    @GeneratedValue(generator = "increment")
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private Boolean status;

    public Plan() { }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Boolean getStatus() { return status; }

    public void setStatus(Boolean status) { this.status = status; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plan plan = (Plan) o;
        return Objects.equals(name, plan.name) &&
                Objects.equals(status, plan.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status);
    }

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
