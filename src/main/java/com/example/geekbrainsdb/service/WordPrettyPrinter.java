package com.example.geekbrainsdb.service;

import com.example.geekbrainsdb.model.Word;
import com.example.geekbrainsdb.model.WordCountResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WordPrettyPrinter {

    private Logger logger = LoggerFactory.getLogger(WordPrettyPrinter.class);

    private ObjectMapper objectMapper;

    public WordPrettyPrinter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String printResponse(List<Word> words){
        WordCountResponse response = new WordCountResponse(words);
        String printedResult = "";
        try {
             printedResult = objectMapper.writerFor(WordCountResponse.class).writeValueAsString(response);
        } catch (JsonProcessingException e) {
            logger.error("Error during Json printing",e);
        }
        logger.debug("Printed result: {}", printedResult);
        return printedResult;

    }


}
