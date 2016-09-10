package ru.imataras.clinic;

/**
 * TODO: comment
 * @author imataras
 * @since 06.09.2016
 */

public interface Pet {

    /**
     * Имя животного.
     * @param name
     * @return
     */
    void setName(String name);

    /**
     * ID.
     * @return
     */
    int getId();

    /**
     * Имя животного.
     * @return
     */
    String getName();

    /**
     * ID.
     * @param id
     */
    void setId(int id);

}
