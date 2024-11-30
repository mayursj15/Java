package com.mayur.streams.a_intro;

import com.mayur.streams.City;
import com.mayur.streams.Person;

import java.util.Arrays;
import java.util.List;

public class FlatMapStream {
    public static void main(String[] args) {
        Person p1 = new Person("Paul", 25);
        Person p2 = new Person("Sarah", 27);
        Person p3 = new Person("James", 31);
        Person p4 = new Person("Julie", 25);
        Person p5 = new Person("Charles", 22);
        Person p6 = new Person("Charlotte", 31);
        Person p7 = new Person("Ann", 27);
        Person p8 = new Person("Boris", 29);
        Person p9 = new Person("Emily", 34);
        Person p10 = new Person("", 34);
        List<Person> personList = List.of(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);

        City newYork = new City("NewYork", Arrays.asList(p1, p2, p3));
        City paris = new City("Paris", Arrays.asList(p4, p5, p6));
        City london = new City("London", Arrays.asList(p7, p8, p9));

        List<City> cities = Arrays.asList(newYork, paris, london);

        /**
         * Flatmap always take object and return stream.
         * Flatmap used to deal to with one to many relationship         *
         */
        Long count = cities.stream().flatMap(c -> c.getPeople().stream())
                .count();

        System.out.printf("count is " + count);

        // get all people
        cities
                .stream()
                .flatMap(city -> city.getPeople().stream())
                .forEach(t -> System.out.println(t));

        //get names of of people
        cities.stream().flatMap(city -> city.getPeople().stream())
                .map(p -> p.getName())
                .forEach(t -> System.out.println(t));





    }
}


