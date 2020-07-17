package com.example.geekbrainsdb.model;

import java.io.Serializable;
import java.util.List;

/**
 * Этот класс обертка необходим, потому что в Json сериализуется класс, а List<Word>
 *     в ObjectMapper передать нельзя.
 *
 *     Serializable на всех классах данных, которые планируется передавать по сети, либо конвертировать в JSON
 *     обязателен.
 */
public class WordCountResponse implements Serializable {

    private List<Word> words;

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public WordCountResponse(List<Word> words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return "WordCountResponse{" +
                "words=" + words +
                '}';
    }
}
