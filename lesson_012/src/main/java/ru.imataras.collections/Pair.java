package ru.imataras.collections;

/**
 * TODO: comment
 * @author imataras
 * @since 23.11.2016
 */

public class Pair<T, K> {

    public final T key;
    public final K value;

    public Pair(T key, K value) {
        this.key = key;
        this.value = value;
    }

}
