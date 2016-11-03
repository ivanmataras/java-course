package ru.imataras.clinic;

/**
 * Класс описывает животного.
 *
 * @author imataras
 * @since 22.09.2016
 */

public class Animal implements Pet {

    private String name;
    private int id;

    public Animal(final String name) {
        this.name = name;
    }

    /**
     * Имя животного.
     *
     * @param name
     * @return
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * ID.
     *
     * @return
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * Имя животного.
     *
     * @return
     */
    @Override
    public String getName() {
        return this.getName();
    }

    /**
     * ID.
     *
     * @param id
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.getName();
    }

}
