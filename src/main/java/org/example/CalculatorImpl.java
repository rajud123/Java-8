package org.example;

@FunctionalInterface
interface Calulator {

//    void switchOn();
//    void add(int n);
    int substract( int i1, int i2);
}


public class CalculatorImpl {

    public static void main(String[] args) {
        /*Calulator calulator = () -> System.out.println("doing some math");
        calulator.switchOn();*/

       /* Calulator calulator = (n)-> System.out.println( "printing "+n);
        calulator.add(4);*/

       /* Calulator calulator =  (i1, i2) ->{
            return i2 -i1;
        };
        //we can avoid return wheb there is only one line of code
        Calulator calulator1 = (i1, i2) ->  i2 -i1;
        System.out.println(calulator1.substract(5,2));*/

        //for multiple statments
        Calulator calulator = (i1, i2) -> {
            if(i2 <i1){
                throw  new IllegalArgumentException("Illegal Arguments");
            }return i2-i1;
        };

        System.out.println(calulator.substract(10,9));
    }
}
