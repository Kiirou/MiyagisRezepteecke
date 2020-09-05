package com.example.miyagisrezepteecke;

public class Steps {

    private int id;
    private String name;
    private String recipesteps;


    public Steps(String name, String recipesteps, int id) {
        this.name = name;
        this.recipesteps = recipesteps;
        this.id = id;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecipesteps() {
        return recipesteps;
    }

    public void setRecipesteps(String recipesteps) {
        this.recipesteps = recipesteps;
    }


}

