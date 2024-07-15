package org.example.find.nth.highest.sal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindNthHighestSal {

    public static void main(String[] args) {

        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1000);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);//output
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);



        Map.Entry<String,Integer> finalResult=  map1.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> -entry.getValue())) // minus make it to do in desc order
                .toList()
                .get(1);
        System.out.println(finalResult);
    }


}
