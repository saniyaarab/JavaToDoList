package com.example.todo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Task {
    private String Description;

    @Id
    private int Id;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
