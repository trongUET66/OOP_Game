package org.example.demo;

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class DictionaryManagement extends Dictionary {
    private static final String IN_PATH = "src/main/resource/words/dictionaries.txt";
    private static final String OUT_PATH = "src/main/resource/words/dictionaries_out.txt";
    public static void insertFromCommandLine() {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int i = 0;
        while (i < size) {
            String target = sc.nextLine();
            String explain = sc.nextLine();
            Word newWord = new Word(target, explain);
            words.add(newWord);
            i++;
        }
    }

    public static void insertFromFile() {
        try {
            File inFile = new File(IN_PATH);
            FileReader fileReader = new FileReader(inFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] wordsInLine = line.split(",");
                Word temp = new Word(wordsInLine[0], wordsInLine[1]);
                words.add(temp);

            }
            Collections.sort((List) words);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
