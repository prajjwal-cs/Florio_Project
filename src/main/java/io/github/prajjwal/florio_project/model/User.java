/* Created by IntelliJ IDEA.

Author: Prajjwal Pachauri(cypher)
Date: 24-05-2022
Time: 19:06
File: User.java */
package io.github.prajjwal.florio_project.model;

public class User {
    private int userID;
    private String name;
    private long phone;
    private String email;
    private String password;

    public User(String name, long phone, String email, String password) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}