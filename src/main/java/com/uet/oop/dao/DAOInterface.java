package com.uet.oop.dao;

import com.uet.oop.model.Word;

import java.util.List;

public interface DAOInterface<T> {

    int insert(Word word);

    int update(Word word);

    int delete(Word word);

    List<Word> selectAll();

    Word findById(int id);

    Word findByTarget(String target);

    List<Word> selectByCondition(String condition);
}
