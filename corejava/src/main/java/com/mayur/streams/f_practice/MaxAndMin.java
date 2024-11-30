package com.mayur.streams.f_practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxAndMin {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,6,4,5);

        Integer max = list.stream().max(Comparator.naturalOrder()).orElseThrow();
        Integer min = list.stream().min(Comparator.naturalOrder()).orElseThrow();

        System.out.println(max);
        System.out.println(min);
    }

}

