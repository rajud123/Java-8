package org.example.stream.foreach.filter;

import org.example.stream.foreach.filter.dto.Employee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ForEachFilterDemo {

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
        List<Integer> integers = Arrays.asList(3, 5, 1, 56, 3);
        List<String> names = Arrays.asList("Stephen", "Roger", "David", "Nick", "Abhishek");
        //traditionl for each loop
        for (int i : integers) {
            System.out.println(i);
        }
        //stream api for-each
        integers.forEach(i -> System.out.print("printing " + i + " ;"));

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "abca");
        map.put(2, "abcb");
        map.put(3, "abcc");
        map.put(4, "abcd");
        map.put(5, "abce");

       /* map.forEach((k,v)-> System.out.println(k +" : "+v));
        map.entrySet().stream().forEach(entry -> System.out.println(entry));
        map.keySet().forEach(key -> System.out.println(key));
        map.values().forEach(val -> System.out.println(val));
*/
        //filtering the list of names who's name starts with letter A

        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);

        //print only even keys of map using filter
        map.entrySet().stream().filter(entry -> entry.getKey()%2==0).forEach(System.out::println);

        Map<Integer, Employee> allEmployees = getAllEmployees();
        //filter employees whose salary is greater than 150000
        allEmployees.entrySet().stream().filter(entry->entry.getValue().getSalary()>150000).forEach(System.out::println);
    }
}
