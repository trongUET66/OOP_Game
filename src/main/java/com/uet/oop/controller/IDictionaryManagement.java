package com.uet.oop.controller;

import com.uet.oop.model.Question;
import com.uet.oop.model.Word;

import java.util.List;

public interface IDictionaryManagement {

    void insertWord(Word newWord);

    void insertFromFile(String filepath);

    void removeWord(String target);

    void updateWord(Word word);

    List<Word> getAllWord();

    Word lookup(String wordTarget);

    List<Word> search(String wordTarget);

    List<Question> mixGames();

    void importFromFile(String filepath);

    void exportToFile(String filepath);

}
