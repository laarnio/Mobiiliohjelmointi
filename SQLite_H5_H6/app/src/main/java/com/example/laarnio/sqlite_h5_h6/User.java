package com.example.laarnio.sqlite_h5_h6;

/**
 * Created by laarnio on 5.3.2018.
 */

public class User {
    public String id;
    public String name;
    public String surname;
    public String points;

    public User (String id, String name, String surname, String points) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.points = points;
    }
}
