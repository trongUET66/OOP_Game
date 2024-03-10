package com.uet.oop.model;

public class Word {
    private int id;
    private String target;
    private String definition;

    public Word(String target, String definition) {
        this.target = target;
        this.definition = definition;
    }

    public Word(int id, String target, String definition) {
        this.id = id;
        this.target = target;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
