package model;

import java.time.LocalDate;

public class User {
    private int id;
    private String fullName;
    private final LocalDate dateOfBirth;

    public User(int id, String fullName, LocalDate dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}