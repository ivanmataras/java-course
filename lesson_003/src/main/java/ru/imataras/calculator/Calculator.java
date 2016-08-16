package ru.imataras.calculator;

/**
 * @author imataras
 * @since 02.08.2016
 */

public class Calculator implements ICalculator {

    private double result;

    @Override
    public double getResult() {
        return this.result;
    }

    @Override
    public void add(double first, double second) {
        this.result = first + second;
    }

    @Override
    public void substract(double first, double second) {
        this.result = first - second;
    }

    @Override
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    @Override
    public void divide(double first, double second) {
        try {
            this.result = first / second;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void expand(double first, double second) {
        this.result = Math.pow(first, second);
    }

    @Override
    public void clearResult() {
        this.result = 0;
    }

}
