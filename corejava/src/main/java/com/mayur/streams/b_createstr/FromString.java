package com.mayur.streams.b_createstr;

public class FromString {

    public static void main(String[] args) {
        String sentence = "Java stream API is very useful";

        sentence.chars()
                .mapToObj(code -> Character.toString(code))
                .filter(letter->!letter.equals(" "))
                .distinct()
                .sorted()
                .forEach(System.out::println);

    }
}
