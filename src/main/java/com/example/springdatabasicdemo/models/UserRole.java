package com.example.springdatabasicdemo.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "role")
    private Role role;
    @OneToMany(mappedBy = "userRole",cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<User> users;
    public UserRole(){}

    public UserRole(UUID id, Role role, List<User> users) {
        this.id = id;
        this.role = role;
        this.users = users;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
    public enum Role {
        User(0), Admin(1);
        private int number;
        Role(int number) {
            this.number=number;
        }
        public int getNumber(){
            return number;
        }
    }
}
