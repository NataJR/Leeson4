package com.example.geekbrainsdb.model;

import com.example.geekbrainsdb.service.WordCountService;
import com.example.geekbrainsdb.service.WordPrettyPrinter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

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

    @Value("classpath:duneshort.txt")
    private Resource resource;

    public static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Test
    void testBook() {
        String textDune = asString(resource);
        List<Word> result = wordCountService.countWords(textDune);
        String s = prettyPrinter.printResponse(result);
        System.out.println(s);
//        Assertions.assertEquals("{\"words\":[{\"word\":\"am\",\"count\":2},{\"word\":\"i\",\"count\":1},{\"word\":\"grut\",\"count\":1}]}", s);
    }

}