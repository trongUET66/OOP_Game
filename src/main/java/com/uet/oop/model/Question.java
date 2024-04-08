package com.uet.oop.model;

public class Question {

    private String question;
    private String a;
    private String b;
    private String c;
    private String d;

    public Question(String question, String a, String b, String c, String d) {
        this.question = question;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public String getQuestion() {
        return question;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }
}
