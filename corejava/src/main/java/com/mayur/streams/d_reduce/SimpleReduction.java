package com.mayur.streams.d_reduce;

import java.util.List;
import java.util.Optional;

public class SimpleReduction {

    public static void main(String[] args) {

        List<Integer> ints = List.of(1, 1, 1, 1, 1);

        /**
         * identity element not provided  hence its return is Optional
         */
        Optional<Integer> sumOfTwoNumber = ints.stream().reduce((a, b) -> a + b);

        // orElse introduced in Java 10
        System.out.println(sumOfTwoNumber.orElseThrow());

        /**
         * if list is empty, it throw No such element present as its empty
         */

        List<Integer> emptyList = List.of();

        Optional<Integer> reduce = emptyList.stream().reduce((a, b) -> a + b);

        System.out.println(reduce.orElse(0));


        /**
         *  Let's add identity, we have to very carefull if while adding identity if we pass wrong identity it will give wrong result
         *
         *  ints.stream().reduce(0, (a, b) -> a + b);
         *  here it actally works as : 0 + 1 + 1 + 1 + 1 = 4 which is correct
         *  but
         *  ints.stream().reduce(10, (a, b) -> a + b);
         *  here we gave buggy identity hence here result is 14, here developer has to be very carefull because compiler wont capture this
         *
         */
        int sum = ints.stream().reduce(0, (a, b) -> a + b);

        System.out.println("sum should be 5 " + sum);

        int sumWithWrongIdentity = ints.stream().reduce(10, (a, b) -> a + b);

        System.out.println("sum should be 15 as 10 is wrong identity " + sumWithWrongIdentity);


    }
}
