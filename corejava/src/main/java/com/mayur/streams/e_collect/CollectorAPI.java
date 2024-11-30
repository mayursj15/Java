package com.mayur.streams.e_collect;

import com.mayur.streams.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorAPI {


    /**
     * Grouping By
     */

    public static void main(String[] args) {
        Employee e1 = Employee.builder().age(25).name("john").salary(10000.0).city("newyork").build();
        Employee e2 = Employee.builder().age(35).name("julie").salary(30000.0).city("newyork").build();
        Employee e3 = Employee.builder().age(45).name("sarah").salary(50000.0).city("paris").build();
        Employee e4 = Employee.builder().age(21).name("james").salary(5000.0).city("newyork").build();
        Employee e5 = Employee.builder().age(55).name("paul").salary(100000.0).city("paris").build();
        Employee e6 = Employee.builder().age(34).name("adam").salary(10000.0).city("newyork").build();

        List<Employee> employeeList = List.of(e1, e2, e3, e4, e5, e6);

        /// 1. map of city name and list of employee staying there
        Map<String, List<Employee>> cityEmployeeMap = employeeList
                .stream()
                .collect(Collectors.groupingBy(Employee::getCity));

        //paris=[Employee(age=45, name=sarah, salary=50000.0, city=paris), Employee(age=55, name=paul, salary=100000.0, city=paris)]
        //newyork=[Employee(age=25, name=john, salary=10000.0, city=newyork), Employee(age=35, name=julie, salary=30000.0, city=newyork), Employee(age=21, name=james, salary=5000.0, city=newyork), Employee(age=34, name=adam, salary=10000.0, city=newyork)]
        cityEmployeeMap.entrySet().stream().forEach(System.out::println);

        ///  2. map of city and number of employee of that city
        Map<String, Long> cityEmployeeNoOfEmpMap = employeeList.stream().
                collect(Collectors
                        .groupingBy(Employee::getCity,
                                Collectors.counting()));
        System.out.println(cityEmployeeNoOfEmpMap); // {paris=2, newyork=4}


        ///  3. map of city and name of the employee living in that city
        Map<String, Set<String>> mapOfCityAndNameOfEmp = employeeList.stream().collect(Collectors.groupingBy(Employee::getCity, Collectors.mapping(Employee::getName, Collectors.toSet())));
        System.out.println(mapOfCityAndNameOfEmp); // {paris=[sarah, paul], newyork=[julie, adam, james, john]}





        /*















        Map<String, List<Employee>> empMap = employeeList.stream()
                .collect(Collectors
                        .groupingBy(e -> e.getCity()));

        System.out.println(empMap.size());
        System.out.println(empMap.get("newyork"));


        /// grouping by 2

        Map<String, Long> res = employeeList.stream()
                .collect(Collectors.groupingBy(city -> city.getCity(), Collectors.counting()));

        System.out.println(res);

        Map.Entry<String, Long> res1 = res.entrySet()
                .stream()
                .max(Comparator
                        .comparing(entry -> entry.getValue()))
                .orElseThrow();

        // can be writtern as

        Map.Entry<String, Long> res2 = res.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow();

        System.out.println(res1);
        System.out.println(res2);



        // sum salary of new york employee

        Double salarySum = empMap.get("newyork").stream()
                .collect(Collectors.summingDouble(e->e.getSalary()));

        System.out.println(salarySum);*/


    }
}
