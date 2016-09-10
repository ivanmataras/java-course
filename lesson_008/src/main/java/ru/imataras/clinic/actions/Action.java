package ru.imataras.clinic.actions;

import ru.imataras.clinic.IClinic;
import ru.imataras.interact.Validator;

/**
 * TODO: comment
 * @author imataras
 * @since 06.09.2016
 */

public interface Action {

    /**
     * Выполнить действие.
     * @param clinic Клиника.
     * @param validator Валидатор ввода.
     */
    void execute(final IClinic clinic, final Validator validator);

    /**
     * Описание действия.
     * @return Описание.
     */
    String intro();

    /**
     * Ключ.
     * @return ключ.
     */
    int key();

}
