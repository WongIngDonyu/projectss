package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "group_id", referencedColumnName = "id", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Group group;

    public Student(String name) {
        this.name = name;
    }

    // Пустой конструктор для Hibernate, обратите внимание на модификатор доступа
    protected Student(){
    }

    @Column(name = "name", length = 50, nullable = false)
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student { id=" + id + ", name=" + name + " }";
    }
}
