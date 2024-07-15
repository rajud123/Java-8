package org.example.map.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EkartDataBase {

    public static List<Customer> getAll() {
        return Stream.of(
                new Customer(101, "john", "john@gmail.com", Arrays.asList("397937955", "21654725")),
                new Customer(102, "smith", "smith@gmail.com", Arrays.asList("89563865", "2487238947")),
                new Customer(103, "peter", "peter@gmail.com", Arrays.asList("38946328654", "3286487236")),
                new Customer(104, "kely", "kely@gmail.com", Arrays.asList("389246829364", "948609467"))
        ).collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Customer> all = getAll();
        //get all emails
        all.stream().map(cust -> cust.getEmail()).forEach(System.out::println);
        //get all names
        System.out.println("//get all names");
        List<String> collect = all.stream().map(cust -> cust.getName()).collect(Collectors.toList());
        collect.forEach(System.out::println);

        //get all names in upper case
        System.out.println(" //get all names in upper case");
        all.stream().map(cust -> cust.getName().toUpperCase()).forEach(System.out::println);

        //get all phones numbers
        System.out.println("//get all phones numbers");
        List<List<String>> collect1 = all.stream().map(cust -> cust.getPhoneNumbers()).collect(Collectors.toList());
        collect1.forEach(System.out::println);

/*          [397937955, 21654725]
            [89563865, 2487238947]
            [38946328654, 3286487236]
            [389246829364, 948609467]*/

        //get all phone numbers invidually
        System.out.println("//get all phone numbers invidually");
        //since flatmap takes stream of streams so we added .stream()
        all.stream().flatMap(customer -> customer.getPhoneNumbers().stream()).forEach(System.out::println);

/*        397937955
        21654725
        89563865
        2487238947
        38946328654
        3286487236
        389246829364
        948609467
    }*/

    }
}
