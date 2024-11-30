package com.mayur.streams.f_practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OddEvenNumber {

    public static void main(String[] args) {

        List<Integer> listOfInts = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> res = listOfInts.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println("True means even as it satisfies the condition"  + res);




    }
}
