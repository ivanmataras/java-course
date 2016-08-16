package ru.imataras.interact;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 06.08.2016
 */
public class CalculatorTest {
    @Test
    public void whenAddShouldSummateIt() {
        final Calculator calc = new Calculator();
        calc.add(1, 1);
        final double result = calc.getResult();
        assertThat(result, is(2d));
    }
}
