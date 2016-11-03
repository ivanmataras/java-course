package ru.imataras.engineer;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author imataras
 * @since 30.10.2016
 */
public class EngineerCalcTest {

    @Test
    public void percent() {
        try {
            assertThat(new EngineerCalc().percent(100, 1), is(1d));
        } catch (UserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void percentUniversal() {
        assertThat(new EngineerCalc().percentUniversal(100, 1), is(new Option<Double>(1d)));
    }

    @Test
    public void percentCorrect() throws UserException {

        final EngineerCalc calc = new EngineerCalc();
        final double result = calc.percent(100, 1);
        assertThat(result, is(1d));
    }

    @Test(expected = UserException.class)
    public void whenPercenIsLessZeroShouldThrowException() throws UserException {
        new EngineerCalc().percent(100, 0);
    }

}
