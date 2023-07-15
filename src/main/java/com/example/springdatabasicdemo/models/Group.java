package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Set<Student> students;

    public Group(String name) {
        this.name = name;
        students = new HashSet<Student>();
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Group(){

    }

    @Column(name = "name", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group { id=" + id + ", name=" + name + " }";
    }
}
