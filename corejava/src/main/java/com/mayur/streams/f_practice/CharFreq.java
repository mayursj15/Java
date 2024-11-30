package com.mayur.streams.f_practice;

import javax.xml.stream.events.Characters;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharFreq {
    public static void main(String[] args) {
        // Find the frequency of each character in a string using Java 8 streams

        String stmt = "Stream api is good , fast and helpful";

        Map<String, Long> res = stmt.chars()
                .mapToObj(c -> Character.toString(c))
                .filter(c -> !c.equalsIgnoreCase(" "))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        System.out.println(res);

    }
}
