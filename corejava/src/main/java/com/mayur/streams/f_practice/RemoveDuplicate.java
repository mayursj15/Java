package com.mayur.streams.f_practice;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "python", "ruby", "java", "sql", "python");
        List<String> res = list.stream().distinct().collect(Collectors.toList()); // can be done using set also
        Set<String> resSet = list.stream().collect(Collectors.toSet()); // can be done using set also
        System.out.println(list);
        System.out.println(res);
        System.out.println(resSet);
    }
}

