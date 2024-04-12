package com.uet.oop.Management;

import com.uet.oop.model.Question;
import com.uet.oop.model.Word;

import java.util.ArrayList;
import java.util.List;

public interface IDictionaryManagement {
    void insertWord();

    void removeWord(String target);

    void updateWord(Word word);

    List<Word> getAllWord();

    Word lookup(String wordTarget);

    ArrayList<Word> search(String wordTarget);

    void mixGames();

    void importFromFile();

    void exportToFile();

}
