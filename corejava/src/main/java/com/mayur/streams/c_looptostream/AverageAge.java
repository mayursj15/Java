package com.mayur.streams.c_looptostream;

import com.mayur.streams.Person;

import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BinaryOperator;

public class AverageAge {

    public static void main(String[] args) {
        Person p1 = new Person("Paul", 25);
        Person p2 = new Person("Sarah", 27);
        Person p3 = new Person("James", 31);
        Person p4 = new Person("Julie", 15);
        Person p5 = new Person("Charles", 22);

        List<Person> people = List.of(p1, p2, p3, p4, p5);

        // find average age from employee who are older than 20
        /**
         *
         * Average method is not available on Stream<t>
         * its available on IntStream, LongStream, DoubleStream 
         * so its available only in number stream we would use mapToInt instead of map
         *
         *
         */

        /**
         * If a single for loop doing multiple things then
         *    1. Convert each task of loop into loop i.e. if single for loop is doing 3 tasks
         *       then create 3 for loops to execute individual task because stream do one task at a time
         *    2. Should be converted into three streams
         *    3. In Streams we not process your data in single pass
         */
        double average = people.stream()
                .mapToInt(Person::getAge) // map will return Stream<T> and mapToInt return IntStream
                .filter(p -> p > 20)
                .average()
                .orElseThrow();

        System.out.println("AverageAge.main::" + average);
    }
}
