package org.example.sort;

import org.example.stream.foreach.filter.dao.EmloyeeDAO;
import org.example.stream.foreach.filter.dto.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortDemo {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList( 3,5,1,56,3);
        integers.stream().sorted().forEach(System.out::println);
        integers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("-------------");
        List<Employee> allEmployees = EmloyeeDAO.getAllEmployees();

        //get all employees within the sorting order of names
        allEmployees.stream().sorted(Comparator.comparing(Employee::getName, String.CASE_INSENSITIVE_ORDER).reversed()).forEach(System.out::println);

        System.out.println("-------------");
        //get employees with salaries in desceinding order
        allEmployees.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);
    }
}
