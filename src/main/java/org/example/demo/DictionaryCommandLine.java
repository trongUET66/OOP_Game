package org.example.demo;

import java.io.IOException;

public class DictionaryCommandLine extends Dictionary {
    public static void showAllWords() {
        System.out.printf("%-6s%c %-15s%c %-20s%n", "No", '|', "English", '|', "Vietnamese");
        for (int i = 0; i < words.size(); i++) {
            System.out.printf("%-6d%c %-15s%c %-15s%n", i + 1, '|', words.get(i).getWord_target(), '|', words.get(i).getWord_explain());
        }
    }

    public static void dictionaryBasic(){
        DictionaryManagement.insertFromCommandLine();
        showAllWords();
    }
}
