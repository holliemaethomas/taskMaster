package com.thhollie.taskMaster;

public class Task {

    private String title;
    private String description;
    public String state;



    public Task(String title, String description) {
        this.title = title;
        this.description = description;
        this.state = "New";
    }


    public Task() {

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getState(){
        return state;
    }

    public void setTitle() {
        this.title = title;
    }


    public void setDescription(){
        this.description = description;
    }

    public void setState() {
        this.state = state;

    }

}
