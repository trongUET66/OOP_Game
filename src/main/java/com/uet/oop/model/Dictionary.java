package com.uet.oop.model;

import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public static ArrayList<Word> dictionary = new ArrayList<>();

    public ArrayList<Word> getDictionary() {
        return dictionary;
    }

    public void setDictionary(ArrayList<Word> dictionary) {
        Dictionary.dictionary = dictionary;
    }
}
