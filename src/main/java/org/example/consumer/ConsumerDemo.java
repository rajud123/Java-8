package org.example.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList( 3,5,1,56,3);
        Consumer<Integer> consumer = (i)-> System.out.print("printing " +i+ " ;");

        //foreach() takes consumer interface
        integers.stream().forEach(consumer);
        System.out.println();
        integers.stream().forEach(i-> System.out.print("printing "+i+" ;"));
    }
}
