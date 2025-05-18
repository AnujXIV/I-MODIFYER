package com.example.textrecognitionapp;


public class Credentials {
    String name;
    String password;

    Credentials(String name,String password)
    {
        this.name = name;
        this.password = password;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}