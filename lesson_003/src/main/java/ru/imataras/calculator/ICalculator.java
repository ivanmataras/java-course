package ru.imataras.calculator;

/**
 * @author imataras
 * @since 02.08.2016
 */

public interface ICalculator {

    double getResult();

    void add(double first, double second);

    void substract(double first, double second);

    void multiple(double first, double second);

    void divide(double first, double second);

    void expand(double first, double second);

    void clearResult();

}
