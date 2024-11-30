package com.mayur.streams.e_collect;

import com.mayur.streams.Employee;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ToCollection {

    public static void main(String[] args) {

        Employee e1 = Employee.builder().age(25).name("john").salary(10000.0).city("newyork").build();
        Employee e2 = Employee.builder().age(35).name("julie").salary(30000.0).city("newyork").build();
        Employee e3 = Employee.builder().age(45).name("sarah").salary(50000.0).city("paris").build();
        Employee e4 = Employee.builder().age(21).name("james").salary(5000.0).city("newyork").build();
        Employee e5 = Employee.builder().age(55).name("paul").salary(100000.0).city("paris").build();
        Employee e6 = Employee.builder().age(34).name("adam").salary(10000.0).city("newyork").build();

        List<Employee> employeeList = List.of(e1, e2, e3, e4, e5, e6);


        List<String> list = employeeList.stream()
                .map(p -> p.getCity())
                .collect(Collectors.toList());

        System.out.println(list);

        String[] arr = list.toArray(String[]::new);

        System.out.println(arr.length);

        String joined = list.stream().collect(Collectors.joining(", ", "{", "}"));

        System.out.println("joined -- " + joined);

        String emptyString = Stream.<String>empty().collect(Collectors.joining(", ", "{", "}"));

        System.out.println("emptyString:: " + emptyString);


    }


}
