package com.uet.oop.controller;

import com.uet.oop.model.Question;
import com.uet.oop.model.Word;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class FakeDictionaryManagement implements IDictionaryManagement {

    private final ArrayList<Word> words = new ArrayList<>();

    @Override
    public void insertWord(Word newWord) {
        words.add(newWord);
    }

    @Override
    public void insertFromFile(String filepath) {

    }

    @Override
    public void removeWord(String target) {
        Word foundWord = lookup(target);
        words.remove(foundWord);
    }

    @Override
    public void updateWord(Word word) {
        Word foundWord = lookup(word.getTarget());
        int index = words.indexOf(foundWord);
        if (index >= 0) {
            words.set(index, word);
        }
    }

    @Override
    public List<Word> getAllWord() {
        return words;
    }

    @Override
    public Word lookup(String wordTarget) {
        List<Word> foundWords = words.stream()
                .filter(word -> word.getTarget().equals(wordTarget))
                .toList();

        if (foundWords.isEmpty()) {
            return null;
        }

        return foundWords.getFirst();
    }

    @Override
    public List<Word> search(String wordTarget) {
        return words.stream()
                .filter(word -> word.getTarget().contains(wordTarget))
                .toList();
    }

    @Override
    public List<Question> mixGames() {
        return List.of();
    }

    @Override
    public void importFromFile(String filePath) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }

        words.clear();

        String splitPattern;
        String htmlStart;

        splitPattern = "\t";
        htmlStart = "";
//        if (filePath.equals(PATH_DICTIONARY_FILE)) {
//
//        } else if (filePath.equals(PATH_DICTIONARY_HTML_FILE)) {
//            splitPattern = "<html>";
//            htmlStart = "<html>";
//        } else {
//            System.err.println("Invalid file");
//            return;
//        }

        String line;
        try {

            while ((line = bufferedReader.readLine()) != null) {
                String[] wordParts = line.split(splitPattern);
                String target = wordParts[0];
                String explain = htmlStart + wordParts[1];
                Word word = new Word(target.toLowerCase(), explain);
                words.add(word);
            }
        } catch (Exception e) {

        }

        try {
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void exportToFile(String filePath) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String separator;
        separator = "\t";

        StringBuilder content = new StringBuilder();
        for (Word word : getAllWord()) {
            content.append(word.getTarget()).append(separator);
            content.append(word.getExplain()).append("\n");
        }

        try {
            fileWriter.write(content.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
