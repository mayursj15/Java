package com.mayur.streams.f_practice;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CreateStringJoin {
    public static void main(String[] args) {
        String str = Stream.<String>empty().collect(joining(",", "[", "]"));
        System.out.println(str);
    }

}
