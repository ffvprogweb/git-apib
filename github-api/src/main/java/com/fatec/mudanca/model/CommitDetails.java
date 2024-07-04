package com.fatec.mudanca.model;

public class CommitDetails {
    private String message;
    private String date;
    private String name;

    public CommitDetails(String message, String date, String name) {
        this.message = message;
        this.date = date;
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public String getName() {
    	return name;
    }
    
}