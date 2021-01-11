package com.training.hr.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "app_user" ,catalog = "hr")
public class User  implements Serializable{
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY )
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name" ,unique = true)
    private String userName;

    @Column(name="password" ,unique = true)
    private String password;

    @Column(name = "active" ,nullable = false)
    private boolean active ;


    public User() {
    }

    public User(int id, String userName, String password, boolean active) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
