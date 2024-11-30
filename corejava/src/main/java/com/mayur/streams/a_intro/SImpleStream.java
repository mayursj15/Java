package com.mayur.streams.a_intro;

import com.mayur.streams.Person;

import java.util.List;

public class SImpleStream {

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

        Long emptyNames = personList.stream()
                .map(person -> person.getName())
                .filter(name -> name.isEmpty())
                .count();

        System.out.println("Empty Names " + emptyNames);
    }
}

