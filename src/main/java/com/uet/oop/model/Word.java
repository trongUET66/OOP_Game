package com.uet.oop.model;

import java.util.Comparator;

public class Word implements Comparable<Word>{
    private long id = 0;
    private String target;
    private String explain;

    public Word() {
        target="";
        explain="";
    }

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

    public int compareTo(Word otherWord) {
        return this.getTarget().compareTo(otherWord.getTarget());
    }
}
