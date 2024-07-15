package org.example.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {
    public static void main(String[] args) {
        Predicate<Integer> predicate = t -> t%2==0;
        System.out.println(predicate.test(5));
        System.out.println(predicate.test(4));
        List<Integer> integers = Arrays.asList( 3,5,1,56,3);
        //filter tskes predicate interface
        integers.stream().filter(predicate).forEach(t-> System.out.println("print even :"+t));
        integers.stream().filter(input -> input%2!=0).forEach(out -> System.out.println("print odd numbers :"+ out));
    }
}
