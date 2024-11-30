package com.mayur.streams.d_reduce;

import com.mayur.streams.Employee;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;

public class MaxAndMin {

    public static void main(String[] args) {

        Employee e1 = Employee.builder().age(25).name("john").salary(10000.0).city("newyork").build();
        Employee e2 = Employee.builder().age(35).name("julie").salary(30000.0).city("newyork").build();
        Employee e3 = Employee.builder().age(45).name("sarah").salary(50000.0).city("paris").build();
        Employee e4 = Employee.builder().age(21).name("james").salary(5000.0).city("newyork").build();
        Employee e5 = Employee.builder().age(55).name("paul").salary(100000.0).city("paris").build();
        Employee e6 = Employee.builder().age(34).name("adam").salary(10000.0).city("newyork").build();

        List<Employee> employeeList = List.of(e1, e2, e3, e4, e5, e6);

        // min salary of employee

        Double minSalary = employeeList.stream()
                .mapToDouble(emp -> emp.getSalary())
                .min()
                .orElseThrow();

        System.out.println("Minimum salary is " + minSalary);


        /// prints statistics of the operation
        /// DoubleSummaryStatistics{count=6, sum=205000.000000, min=5000.000000, average=34166.666667, max=100000.000000}
        DoubleSummaryStatistics summaryStatistics = employeeList.stream()
                .mapToDouble(emp -> emp.getSalary())
                .summaryStatistics();

        System.out.println(summaryStatistics);


        /**
         *     identity: The identity value for the reduction (initial value).
         *     accumulator: A function that combines two values.
         *     combiner: A function that combines two partial results.
         */
        employeeList.stream()
                .reduce(
                        0.0, // Identity
                        (abc, sale) -> abc + sale.getSalary(), // Accumulator
                        Double::sum);// combiner
    }
}
