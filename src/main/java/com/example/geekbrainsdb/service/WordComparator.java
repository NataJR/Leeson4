package com.example.geekbrainsdb.service;

import com.example.geekbrainsdb.model.Word;

import java.util.Comparator;

public class WordComparator implements Comparator<Word> {

    @Override
    public int compare(Word o1, Word o2) {
        return o1.getCount().compareTo(o2.getCount());
    }
}
