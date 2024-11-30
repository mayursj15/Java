package com.mayur.streams.b_createstr;

import java.util.stream.IntStream;

public class Range {

    public static void main(String[] args) {

        /**
         *
         * range start from 0
         *
         */
        IntStream.range(0,10)
                .skip(5)
                .limit(2)
                .forEach(System.out::println);
    }
}
