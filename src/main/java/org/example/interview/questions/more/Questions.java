package org.example.interview.questions.more;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Questions {

    public static void main(String[] args) {

        //find the occureances of each character in a string
        String string = "ilovejavatechie";

        System.out.println(" //find the occureances of each character in a string");
        Map<String, Long> collect = Arrays.stream(string.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        //find the characters who are repeated more than once
        System.out.println("//find the characters who are repeated more than once");
        Map<String, Long> collect1 = collect.entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        System.out.println(collect1);

        System.out.println("//find the uniqe elements in string");
        List<String> collect2 = collect.entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(collect2);
        System.out.println("find the first non repeated character in the string");
        String key = Arrays.stream(string.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();

        //we are usingg LinkedHashMap since we want to maintain insertion order so we can get the first occured character according to insertion order.
        System.out.println(key);

        //program to find the 2nd highest number
        System.out.println("//program to find the 2nd highest number");
        Integer i = Arrays.stream(new Integer[]{2, 6, 2, 7, 3, 2, 6, 7}).sorted(Comparator.reverseOrder()).collect(Collectors.toList()).get(2);

        System.out.println(i);

        String[] sports = {"Cricket","Basketball","Football","Badminton","Tennis"};
        //program to find the longest string in array
        System.out.println(" //program to find the longest string in array");
        String s = Arrays.stream(sports).reduce((string1, string2) -> string1.length() > string2.length() ? string1 : string2).get();
        System.out.println(s);

        int numbers[] = new int[]{1, 11, 2, 12, 44};

        List<String> collect3 = Arrays.stream(numbers).boxed().map(itr -> itr+"").filter(str -> str.startsWith("1")).collect(Collectors.toList());
        System.out.println(collect3);


    }
}
