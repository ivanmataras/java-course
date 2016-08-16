package ru.imataras.interact;

/**
 * Реализует калькулятор. Поддерживает вторичное
 * использования предыдущего вычисления.
 * @author imataras
 * @since 02.08.2016
 */
public class Calculator {

    private double result;

    public Calculator() {

    }

    /**
     * Результат.
     * @return
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Вычисляем сложение.
     * @param first первый аргумент.
     * @param second второй аргумент.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычитание.
     * @param first первый агрумент.
     * @param second второй агрумент.
     */
    public void substract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Возведение в степень.
     * @param first первый агрумент.
     * @param second второй агрумент.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Деление. Метод выкинет испключение если второй аргумент равен 0.
     * @param first первый аргумент.
     * @param second второй аргумент.
     */
    public void divide(double first, double second) {
        try {
            this.result = first / second;
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Возведение в степень.
     * @param first первый агрумент.
     * @param second второй агрумент.
     */
    public void expand(double first, double second) {
        this.result = Math.pow(first, second);
    }

    /**
     * Вычисляем арифметическую операцию на основании входных значений.
     * @param operation операция + - * / ^
     * @param first аргумент.
     * @param second аргумент.
     */
    public void calculate(String operation, double first, double second) {
        if ("+".equals(operation)) {
            this.add(first, second);
        } else if ("-".equals(operation)) {
            this.substract(first, second);
        } else if ("*".equals(operation)) {
            this.multiple(first, second);
        } else if ("/".equals(operation)) {
            this.divide(first, second);
        } else if ("^".equals(operation)) {
            this.expand(first, (int) second);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void clearResult() {
        this.result = 0;
    }

}
