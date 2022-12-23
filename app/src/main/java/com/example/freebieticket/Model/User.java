package com.example.freebieticket.Model;

import android.widget.RadioButton;

public class User {
    private String Email;
    private String Name;
    private String SecondName;

    public User(String email, String name, String secondName) {
        Email = email;
        Name = name;
        SecondName = secondName;
    }

    public User() {
    }

    public String getEmail() {
        return Email;
    }

    public String getName() {
        return Name;
    }

    public String getSecondName() {
        return SecondName;
    }
}
