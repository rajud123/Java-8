package org.example.stream.foreach.filter.dao;

import org.example.stream.foreach.filter.dto.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmloyeeDAO {

    public static List<Employee> getAllEmployees(){
        return Arrays.asList(
                new Employee(101, "Abhi","Devops", 1000000l),
                new Employee(102, "Basanth","Developer", 1500000l),
                new Employee(103, "John","LinuxAdmin", 100000l),
                new Employee(104, "Gauri","Cloud", 1200000l),
                new Employee(105, "Max","Admin", 10000l)
        );
    }

    public static void main(String[] args) {
        //who's salary is greater than 5LPA are going to pay tax
         getAllEmployees().stream().filter(emp -> emp.getSalary()>500000).forEach(System.out::println);
        List<Employee> taxpayers = getAllEmployees().stream().filter(emp -> emp.getSalary()>500000).collect(Collectors.toList());
        taxpayers.forEach(System.out::println);

        getAllEmployees().stream().sorted(Comparator.comparing(Employee::getName).reversed()).forEach(System.out::println);
    }
}
