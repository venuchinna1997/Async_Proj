package com.example.Async_Proj.entity;

public class CustomUserDetails {

    public String login;
    public int id;
    public String type;
    public boolean site_admin;

    public CustomUserDetails() {
    }

    public CustomUserDetails(String login, int id, String type, boolean site_admin) {
        this.login = login;
        this.id = id;
        this.type = type;
        this.site_admin = site_admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSite_admin() {
        return site_admin;
    }

    public void setSite_admin(boolean site_admin) {
        this.site_admin = site_admin;
    }

    @Override
    public String toString() {
        return "CustomUserDetails{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", site_admin=" + site_admin +
                '}';
    }
}
