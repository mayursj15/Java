package com.mayur.streams.b_createstr;

import java.util.Arrays;
import java.util.regex.Pattern;

public class FromRegEx {

    public static void main(String[] args) {



        /***
         *
         * Always use Pattern approach
         *
         */
        String sentence = "Java stream api is very useful";

        // this can be traditional way
        String[] words = sentence.split(" ");
        Arrays.stream(words).forEach(System.out::println);

        // Better way no pressure on Memory, CPU
        Pattern.compile(" ").splitAsStream(sentence).forEach(System.out::println);
    }
}
