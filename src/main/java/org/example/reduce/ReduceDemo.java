package org.example.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceDemo {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 4, 3, 8, 2);
//        Integer reduce = integers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("sum");
        Integer reduce = integers.stream().reduce(Integer::sum).get();
        System.out.println(reduce);

        //multply
        System.out.println("  //multply");
        Integer reduce1 = integers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(reduce1);

        System.out.println("greater");
        //Integer reduce2 = integers.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
        Integer reduce2 = integers.stream().reduce(Integer::max).get();
        System.out.println(reduce2);

        List<String> list = Arrays.asList("spring", "hibernate", "core java", "javscript");
        System.out.println("longest string");
        Optional<String> reduce3 = list.stream().reduce((a, b) -> a.length() > b.length() ? a : b);
        System.out.println(reduce3.get());

        //get the average salary of employees whos grade is A
        List<Employee> employees = EmployeeDatabase.getEmployees();

        /*Double avergaeSal = employees.stream().filter(emp->emp.getGrade().equalsIgnoreCase("A")).
                map(emp->emp.getSalary()).
                reduce((sal1, sal2)->(sal1 + sal2)/2).get();*/


        Double avergaeSal =employees.stream().filter(emp->emp.getGrade().equalsIgnoreCase("A")).mapToDouble(Employee::getSalary).average().orElse(0.0);
        System.out.println("average sal :"+avergaeSal);

    }

}
