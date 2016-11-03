package ru.imataras.clinic;

/**
 * Класс описывает пса.
 *
 * @author imataras
 * @since 22.09.2016
 */

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    /**
     * Поймать кота.
     */
    public void catchCat() {

    }

    /**
     * Голодный пес или нет
     *
     * @return true - если голодный.
     */

    public boolean isHungry() {
        return true;
    }

    public String getName() {
        return String.format("Dog says %s.", super.getName());
    }


}
