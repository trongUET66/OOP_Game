package com.uet.oop.dao;

import com.uet.oop.model.Dictionary;

import java.util.ArrayList;

public interface DAOInterface<T> {
    public int insert(T t);
    public int update(T t);
    public int delete(T t);

    int insert(Dictionary dictionary);

    int update(Dictionary dictionary);

    int delete(Dictionary dictionary);

    public ArrayList<Dictionary> selectAll();
    public T selectById(T t);

    Dictionary selectById(Dictionary dictionary);

    public ArrayList<Dictionary> selectByCondition(String condition);
}
