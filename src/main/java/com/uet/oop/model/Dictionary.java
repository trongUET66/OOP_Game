package com.uet.oop.model;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    private ArrayList<Word> dictionary = new ArrayList<>();

    public Dictionary() {
    }

    public List<Word> getDictionary() {
        return dictionary;
    }

    public void setDictionary(ArrayList<Word> dictionary) {
        this.dictionary = dictionary;
    }

}
