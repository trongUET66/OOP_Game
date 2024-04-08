package com.uet.oop.model;

public class Word {
    private long id = 0;
    private String target;
    private String explain;

    public Word(String target, String definition) {
        this.id = 0;
        this.target = target;
        this.explain = definition;
    }

    public Word(long id, String target, String definition) {
        this.id = id;
        this.target = target;
        this.explain = definition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }
}
