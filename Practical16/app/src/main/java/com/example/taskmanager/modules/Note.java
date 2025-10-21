package com.example.taskmanager.modules;

import java.time.LocalDateTime;

public class Note {

    public String title, description;
    public LocalDateTime datetime;

    public Note(String name, String description, LocalDateTime datetime) {
        this.title = name;
        this.description = description;
        this.datetime = datetime;
    }
}
