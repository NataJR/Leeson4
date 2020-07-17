package com.example.geekbrainsdb;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class LoggerTest {

    Logger logger = LoggerFactory.getLogger(LoggerTest.class);


    @ParameterizedTest
    @MethodSource("data")
    public void testLogging(String first, Long second){
        System.out.println(first + second);
    }

    private static Stream<Arguments> data(){
        return Stream.of(Arguments.of("1", 2L), Arguments.of("2", 3L));

    }




}
