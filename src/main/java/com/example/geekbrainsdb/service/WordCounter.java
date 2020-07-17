package com.example.geekbrainsdb.service;

import com.example.geekbrainsdb.model.Word;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;

@Service
public class WordCounter {

    public List<Word> count(List<String> words) {
        Optional<Map<String, Long>> reduce = words.stream()
                .map(String::toLowerCase)
                .map(new Function<String, Map<String, Long>>() {
                    @Override
                    public Map<String, Long> apply(String s) {
                        HashMap<String, Long> result = new HashMap<>();
                        result.put(s, 1L);
                        return result;
                    }
                })
                .reduce(new BinaryOperator<Map<String, Long>>() {
                    @Override
                    public Map<String, Long> apply(Map<String, Long> first, Map<String, Long> second) {
                        for (Map.Entry<String, Long> firstEntry : first.entrySet()) {
                            second.merge(firstEntry.getKey(), firstEntry.getValue(), Long::sum);
                        }
                        return second;
                    }
                });

        if (!reduce.isPresent()) {
            return new ArrayList<>();
        }

        Map<String, Long> stringLongMap = reduce.get();
        List<Word> wordList = toList(stringLongMap);

        return wordList;
    }

    private List<Word> toList(Map<String, Long> stringLongMap) {
        List<Word> words = new ArrayList<>();
        for (Map.Entry<String, Long> stringLongEntry : stringLongMap.entrySet()) {
            words.add(new Word(stringLongEntry.getKey(), stringLongEntry.getValue()));
        }
        return words;
    }

}
