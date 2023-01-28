package com.bogdan_yanushkevich.javacore.rest.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "rest")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "user_name")
    String name;

    @OneToMany(mappedBy = "id",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Event> events;

    public User() {
    }
    public User(Integer id, String userName) {
        this.id = id;
        this.name = userName;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && name.equals(user.name) && Objects.equals(events, user.events);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, events);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", events=" + events +
                '}';
    }
}
