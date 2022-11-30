package com.model;

public class User {
    private String uname;
    private String pass;
    private String email;
    private String city;

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public User(String uname, String pass) {
        this.uname = uname;
        this.pass = pass;
    }

    public User() {

    }

    public User(String uname, String pass, String email, String city) {
        this.uname = uname;
        this.pass = pass;
        this.email = email;
        this.city = city;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
