package com.mayur.streams.f_practice;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortNumberListReverse {


    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 9, 5, 6, 4, 7, 8, 3, 2);
        List<Integer> res = numbers
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("reverse" + res);
    }
}
