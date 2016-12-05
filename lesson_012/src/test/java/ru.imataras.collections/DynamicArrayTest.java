package ru.imataras.collections;

import org.junit.Test;
import ru.imataras.clinic.Dog;
import ru.imataras.clinic.Pet;
import ru.imataras.collections.DynamicArray;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment
 * @author imataras
 * @since 22.08.2015
 */

public class DynamicArrayTest {

    @Test
    public void testWhenAddNewElementArrayShouldIncrementSize() {
        final DynamicArray<Pet> array = new DynamicArray<Pet>(1);
        array.add(new Dog("Sparky"));
        assertThat(array.size(), is(1));
    }

    @Test
    public void testWhenGetElementByIndexItShouldReturnAppropriateValue() {
        final DynamicArray<Pet> array = new DynamicArray<Pet>(1);
        final Pet dog = new Dog("Sparky");
        array.add(dog);
        assertThat(array.get(0), is(dog));
    }

    @Test
    public void testWhenIteratorExecuteItShouldLoopTheSameTimeAsSize() {
        final DynamicArray<Pet> array = new DynamicArray<Pet>(2);
        array.add(new Dog("Sparky"));
        array.add(new Dog("Pepe"));

        int loop = 0;
        for (Pet pet : array) {
            ++loop;
        }

        assertThat(loop, is(array.size()));
    }

    @Test
    public void thesWhenGetIteratorMethodHasNext() {
        final DynamicArray<Pet> array = new DynamicArray<Pet>(2);
        array.add(new Dog("Sparky"));
        array.add(new Dog("Pepe"));
        Iterator iterator = array.iterator();
        assertThat(iterator.hasNext(), is(true));
    }
}
