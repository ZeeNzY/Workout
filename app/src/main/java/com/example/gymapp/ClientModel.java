package com.example.gymapp;

import android.widget.EditText;

public class ClientModel {

    private String name, email, location, password, repeatpassword;

    public ClientModel(String name, String email, String location, String password, String repeatpassword) {
        this.name = name;
        this.email = email;
        this.location = location;
        this.password = password;
        this.repeatpassword = repeatpassword;
    }

    public ClientModel(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatpassword() {
        return repeatpassword;
    }

    public void setRepeatpassword(String repeatpassword) {
        this.repeatpassword = repeatpassword;
    }

    @Override
    public String toString() {
        return "ClientModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", password='" + password + '\'' +
                ", repeatpassword='" + repeatpassword + '\'' +
                '}';
    }
}
