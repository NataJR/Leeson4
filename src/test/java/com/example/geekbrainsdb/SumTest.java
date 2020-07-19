package com.example.geekbrainsdb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class SumTest {

    Logger logger = LoggerFactory.getLogger(SumTest.class);


    @ParameterizedTest
    @MethodSource("data")
    public void testLogging(Long first, Long second, Long expected){
        Assertions.assertEquals(expected, first + second);
    }


    private static Stream<Arguments> data(){
        return Stream.of(Arguments.of(2L, 2L, 4L), Arguments.of(-3L, 3L, 0L));

    }




}
