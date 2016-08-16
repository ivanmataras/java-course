package ru.imataras.calculator;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест для калькутятора.
 * @author imataras
 * @since 02.08.2016
 */
public class CalculatorTest {
    @Test
    public void testWhenPassArgToAddItShouldReturnSumm() {
        final ICalculator calc = new Calculator();
        calc.add(2, 2);
        final double result = calc.getResult();
        assertThat(result, is(4d));
    }

    @Test
    public void testWhenPassArgToSubstractItShouldReturnSubstract() {
        final ICalculator calc = new Calculator();
        calc.substract(2, 2);
        final double result = calc.getResult();
        assertThat(result, is(0d));
    }

    @Test
    public void testWhenPassArgToMultipleItShouldReturnMultiple() {
        final ICalculator calc = new Calculator();
        calc.multiple(2, 2);
        final double result = calc.getResult();
        assertThat(result, is(4d));
    }

    @Test
    public void testWhenPassArgToDivItShouldReturnDiv() {
        final ICalculator calc = new Calculator();
        calc.divide(2, 2);
        final double result = calc.getResult();
        assertThat(result, is(1d));
    }

    @Test
    public void testWhenPassArgToExpandItShouldReturnExpand() {
        final ICalculator calc = new Calculator();
        calc.expand(2, 2);
        final double result = calc.getResult();
        assertThat(result, is(4d));
    }
}
