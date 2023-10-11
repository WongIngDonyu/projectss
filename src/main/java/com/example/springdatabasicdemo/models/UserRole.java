package com.example.springdatabasicdemo.models;

import com.example.springdatabasicdemo.models.enums.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "role")
    private Role role;
    @OneToMany(mappedBy = "userRole", cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    private List<User> users;
    public UserRole(){}

    public UserRole(int id, Role role, List<User> users) {
        this.id = id;
        this.role = role;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
