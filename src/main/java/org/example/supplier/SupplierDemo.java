package org.example.supplier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierDemo {

    public static void main(String[] args) {

        /*Supplier<String> supplier = ()->  {
           return  "Iam return some dummy value"
        };*/
        Supplier<String> supplier = ()-> "Iam return some dummy value";
        List<String> strings = Arrays.asList( "d", "a", "c","l","b");
        System.out.println(strings.stream().findAny().orElseGet(supplier));;
        System.out.println(strings.stream().findAny().orElseGet(()->"Iam Dummy"));;
    }
}
