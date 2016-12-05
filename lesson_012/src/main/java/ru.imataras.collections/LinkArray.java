package ru.imataras.collections;

import java.util.Iterator;

/**
 * TODO: comment
 * @author imataras
 * @since 26.11.2016
 */

public class LinkArray<T> implements Iterable<T> {

    Element<T> first;
    Element<T> last;
    private int size;

    public int size() {
        return this.size;
    }

    public void add(T t) {
        ++size;
        if (this.first == null) {
            this.first = new Element<T>();
            this.first.value = t;
        } else if (this.last == null) {
            this.last = new Element<T>();
            this.last.back = first;
            this.last.value = t;
            this.first.next = this.last;
        } else {
            Element<T> next = new Element<T>();
            next.value = t;
            next.back = this.last;
            this.last.next = next;
            this.last = next;
        }
    }

    private static final class Element<T> {
        Element<T> back;
        Element<T> next;
        T value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private LinkArray.Element<T> pos;

            @Override
            public boolean hasNext() {
                return pos == null || pos.next != null;
            }

            @Override
            public T next() {
                if (pos == null) {
                    pos = first;
                } else {
                    pos = pos.next;
                }
                return pos.value;
            }

            @Override
            public void remove() {

            }
        };
    }
}
