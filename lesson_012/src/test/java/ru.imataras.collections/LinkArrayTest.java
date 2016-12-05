package ru.imataras.collections;


import org.junit.Test;
import ru.imataras.clinic.Dog;
import ru.imataras.clinic.Pet;
import ru.imataras.collections.LinkArray;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 26.11.2016
 */

public class LinkArrayTest {

    @Test
    public void testAdd() {
        final LinkArray<Pet> array = new LinkArray<>();
        Pet dog = new Dog("Sparky");
        array.add(dog);

        assertThat(array.iterator().next(), is(dog));
    }

    @Test
    public void testWhenIteratorExecuteItShouldLoopTheSameTimeAsSize() {
        final LinkArray<Pet> array = new LinkArray<>();
        array.add(new Dog("Sparky"));
        array.add(new Dog("Pepe"));

        int loop = 0;
        for (Pet pet : array) {
            ++loop;
        }

        assertThat(loop, is(array.size()));
    }

}
