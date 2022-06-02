package com.example.n01420704_quiz1;

import java.util.Date;

public class Notes {
    String name, description;
    Date date;
    Boolean priority;

    public Notes(String name, String desc, Date date, Boolean priority){
        this.name=name;
        this.description=desc;
        this.date=date;
        this.priority=priority;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
