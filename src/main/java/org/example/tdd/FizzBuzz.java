package org.example.tdd;

public class FizzBuzz {
    public static String convert(int value) {
        if (value==0) return "0";
        else if (value%3==0) return "Fizz";
        else return value +"";
    }
}
