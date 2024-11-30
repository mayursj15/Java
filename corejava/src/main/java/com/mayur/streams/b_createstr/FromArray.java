package com.mayur.streams.b_createstr;

import com.mayur.streams.Person;

import java.util.Arrays;
import java.util.stream.Stream;

public class FromArray {

    public static void main(String[] args) {
        Person p1 = new Person("Paul", 25);
        Person p2 = new Person("Sarah", 27);
        Person p3 = new Person("James", 31);
        Person p4 = new Person("Julie", 25);
        Person p5 = new Person("Charles", 22);

        Person[] people = {p1, p2, p3, p4, p5};

        /***
         *
         * Stream can be created from Arrays as
         * 1. Using Arrays.stream()
         * 2. Using Stream.of()
         *
         */

        // 1. using factory method of Arrays class
        System.out.println("Using Arrays.stream()");
        Arrays.stream(people).forEach(System.out::println);

        // 2. using factory method of Stream interface (of)
        long count = Stream.of(people).count();
        System.out.println("count using stream of ::" + count);
    }
}
