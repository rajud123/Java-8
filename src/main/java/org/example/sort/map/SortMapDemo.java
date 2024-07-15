package org.example.sort.map;

import org.example.stream.foreach.filter.dto.Employee;

import java.util.*;

public class SortMapDemo {

    public static Map<Integer, Employee> getAllEmployees() {
        Map<Integer , Employee> employeeMap = new HashMap();
        employeeMap.put( 101, new Employee(101, "Abhi", "Devops", 1000000l));
        employeeMap.put( 102, new Employee(102, "Basanth", "Developer", 1500000l));
        employeeMap.put( 103, new Employee(103, "John", "LinuxAdmin", 100000l));
        employeeMap.put( 104, new Employee(104, "Gauri", "Cloud", 1200000l));
        employeeMap.put( 105, new Employee(105, "Max", "Admin", 10000l));

        return employeeMap;
    }

    public static void main(String[] args) {


        Map<Integer, String> map = new HashMap<>();
        map.put(1, "abca");
        map.put(3, "abcc");
        map.put(4, "abcd");
        map.put(5, "abce");
        map.put(2, "abcb");

        //sort map by key
        System.out.println("//sort map by key");
        map.entrySet().stream().sorted(Map.Entry.<Integer, String>comparingByKey()).forEach(entry -> System.out.println(entry));
        //sort by value
        System.out.println("//sort by value");
        map.entrySet().stream().sorted(Map.Entry.<Integer, String>comparingByValue().reversed()).forEach(System.out::println);

        //sort employees by salary
        System.out.println(" //sort employees by salary");
        Map<Integer, Employee> allEmployees = getAllEmployees();
        allEmployees.entrySet().stream().sorted(Map.Entry.<Integer, Employee>comparingByValue(Comparator.comparing(Employee::getSalary).reversed())).forEach(System.out::println);

        //sort employees based on deppartment
        System.out.println("//sort employees based on deppartment");
        allEmployees.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getDept))).forEach(System.out::println);
    }
}
