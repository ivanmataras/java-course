package ru.imataras.interact;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;

/**
 * Валидатор для ввода данных.
 *
 * @author imataras
 * @since 06.08.2016
 */
public class Validator implements Closeable {

    //private static final Logger LOG = LoggerFactory.getLogger(Validator.class);
    private final IO io;

    public Validator(final IO io) {
        this.io = io;
    }

    public double getDouble(String message) {
        boolean invalid = false;
        do {
            try {
                this.io.println(message);
                return Double.valueOf(this.io.read());
            } catch (NumberFormatException e) {
                e.printStackTrace();
                //LOG.error("Convert number error", n);
            }
        } while (invalid);
        throw new UnsupportedOperationException();
    }

    public boolean compare(final String msg, final String answer) {
        System.out.print(msg);
        return answer.equals(io.read());
    }

    /**
     * Считать целое число. Пвторяет ввод пока не будет правильного ввода.
     *
     * @param message
     * @return
     */
    public int getInt(String message) {
        boolean invalid = false;
        do {
            try {
                this.io.println(message);
                return Integer.valueOf(this.io.read());
            } catch (NumberFormatException e) {
                invalid = true;
                System.out.println("Error read of int, Please enter new one.");
            }
        } while (invalid);
        throw new UnsupportedOperationException();
    }

    public int getIntFromList(final String msg, final Collection<Integer> keys) {
        boolean invalid = false;
        do {
            try {
                System.out.print(msg);
                final int result = Integer.valueOf(io.read());
                if (keys.contains(result)) {
                    return result;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException n) {
                invalid = true;
                System.out.println("Error read of int, Please enter new one.");
            }
        } while (invalid);
            throw new UnsupportedOperationException();
    }

    public String getString(String message) {
        System.out.print(message);
        return this.io.read();
    }

    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this
     * method has no effect.
     * <p>
     * <p> As noted in {@link AutoCloseable#close()}, cases where the
     * close may fail require careful attention. It is strongly advised
     * to relinquish the underlying resources and to internally
     * <em>mark</em> the {@code Closeable} as closed, prior to throwing
     * the {@code IOException}.
     *
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void close() {

    }
}
