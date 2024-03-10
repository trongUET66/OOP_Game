package com.uet.oop.model;

import java.util.HashMap;

public class Dictionary extends Word {
    // Giả sử dic là một đối tượng lưu trữ từ điển
    public static HashMap<String, String> dic = new HashMap<>();

    public Dictionary(String target, String definition) {
        super(target, definition);
    }

    public Dictionary(int id, String target, String definition) {
        super(id, target, definition);
    }
}
