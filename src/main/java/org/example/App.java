package org.example;

import java.util.Objects;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        char operator;
        double number1, number2;

        Scanner input = new Scanner(System.in);

        System.out.println("Choose an operator: +, -, *, or /");
        operator = input.next().charAt(0);

        System.out.println("Enter first number");
        number1 = input.nextDouble();

        System.out.println("Enter second number");
        number2 = input.nextDouble();

        switch (operator) {
            case '+' -> System.out.printf("%s + %s = %s%n", number1, number2, number1 + number2);
            case '-' -> System.out.printf("%s - %s = %s%n", number1, number2, number1 - number2);
            case '*' -> System.out.printf("%s * %s = %s%n", number1, number2, Calculator.mul((int) number1, (int) number2));
            case '/' -> System.out.printf("%s / %s = %s%n", number1, number2, number1 / number2);
            default -> System.out.println("Invalid operator!");
        }
        input.close();
    }
}
