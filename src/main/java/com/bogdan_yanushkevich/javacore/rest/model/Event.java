package com.bogdan_yanushkevich.javacore.rest.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    File file;

    public Event() {
    }

    public Event(Integer id, User user, File file) {
        this.id = id;
        this.user = user;
        this.file = file;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id.equals(event.id) && user.equals(event.user) && file.equals(event.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, file);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", user=" + user +
                ", file=" + file +
                '}';
    }
}
