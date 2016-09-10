package ru.imataras.clinic;

import java.util.Collection;

/**
 * TODO: comment
 * @author imataras
 * @since 06.09.2016
 */

public interface Storage<T, K> {

    K put(T key, K value);

    K get(T key);

    K remove(T key);

    Collection<K> values();

}
