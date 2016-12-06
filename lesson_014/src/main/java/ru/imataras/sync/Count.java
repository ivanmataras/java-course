package ru.imataras.sync;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author imataras
 * @since 06.12.2016
 */
public class Count {

    private int value;

    public int increment() {

        synchronized (this) {
            return ++this.value;
        }

    }
}
