package ru.imataras.models;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 29.11.2016
 */
public class UserHashCodeTest {

    @Test
    public void multiple() {
        User first = new User(1, "Petr");
        assertEquals(first.hashCode(), first.hashCode());
    }

    @Test
    public void equalsContract() {
        User first = new User(1, "Petr");
        User second = new User(1, "Petr");
        assertTrue(first.equals(second) && first.hashCode() == second.hashCode());
    }
}
