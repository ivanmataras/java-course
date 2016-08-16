package ru.imataras.interact;

/**
 * Калькулятор. Данные вводяться через консоль.
 * @author imataras
 * @since 06.08.2016
 */

public class ArgRunner {

public static void main (String[] args) {

    Calculator calculator = new Calculator();
    calculator.calculate("+", 2, 2);
    System.out.println(calculator.getResult());
/*    calculator.calculate(args[1], Double.valueOf(args[0]), Double.valueOf(args[2]));
    System.out.println(String.format("%s %s %s = %s", args[0], args[1], args[2], calculator.getResult()));*/
}
}
