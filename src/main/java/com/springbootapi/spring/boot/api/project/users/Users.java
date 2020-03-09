package com.springbootapi.spring.boot.api.project.users;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    private String id;
    private String name;
    private String password;
    private String role;

    public Users() {
    }

    public Users(String id, String name, String role) {
        this.id = id;
        this.name = name;
        this.name = password;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", Role='" + role + '\'' +
                ", Password='" + password + '\'' +
                '}';
    }

}
