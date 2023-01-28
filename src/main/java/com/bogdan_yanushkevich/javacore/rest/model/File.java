package com.bogdan_yanushkevich.javacore.rest.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    @Column(name = "file_name")
    String name;
    @Column(name = "file_path")
    String filePath;

    public File(String filePath, String name) {
        this.name = name;
        this.filePath = filePath;
    }

    public File(Integer id, String name, String filePath) {
        this.id = id;
        this.name = name;
        this.filePath = filePath;
    }

    public File() {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id.equals(file.id) && name.equals(file.name) && filePath.equals(file.filePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, filePath);
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
