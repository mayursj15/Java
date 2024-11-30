package com.mayur.streams.b_createstr;

import java.util.ArrayList;
import java.util.stream.Stream;

public class PredicateStr {

    public static void main(String[] args) {
        Class<?> clazz = ArrayList.class;

        /**
         *  filter does not send element to next step, in our case next step in print so it won't print
         *  but its binary operator still calls with this null hence null pointer exception hence we cant use filter
         *
         *  remove all items from the stream that do not satisfy the condition.
         */

        // code was commented because of exception it was not allowing further execution
      /*  Stream
                .<Class<?>>iterate(clazz, c -> c.getSuperclass())
                .filter(c -> c != null)
                .forEach(System.out::println);*/




        /**
         * it will close / stop stream as soon as take while predicate condition is success         *
         * Abort the stream if condition is success
         */
        Stream.<Class<?>>iterate(clazz, c -> c.getSuperclass())
                .takeWhile(c -> c != null)
                .forEach(System.out::println);
        System.out.println("\n");

        /// will print 123321
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
                .filter(i -> i < 4)
                .forEach(System.out::print);

        /// will print 123 and after that stream will aborted
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
                .takeWhile(i -> i < 4)
                .forEach(System.out::print);
    }
}
