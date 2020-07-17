package com.example.geekbrainsdb.model;

import com.example.geekbrainsdb.service.WordCountService;
import com.example.geekbrainsdb.service.WordPrettyPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WordCountServiceTest {

    @Autowired
    WordCountService wordCountService;

    @Autowired
    WordPrettyPrinter prettyPrinter;

    @Test
    void countWords() {
        List<Word> result = wordCountService.countWords("I am Grut AM");
        Assertions.assertEquals(3, result.size());
    }

    /**
     * Проверяем, что при выводе в строку слова сортируются по убыванию популярности
     */
    @Test
    void testPrettyPrint() {
        List<Word> result = wordCountService.countWords("I am Grut AM");
        String s = prettyPrinter.printResponse(result);
        Assertions.assertEquals("{\"words\":[{\"word\":\"am\",\"count\":2},{\"word\":\"i\",\"count\":1},{\"word\":\"grut\",\"count\":1}]}", s);
    }

}