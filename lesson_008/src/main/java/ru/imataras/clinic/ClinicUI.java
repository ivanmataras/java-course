package ru.imataras.clinic;

import ru.imataras.clinic.actions.Action;
import ru.imataras.interact.Input;
import ru.imataras.interact.Validator;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;

/**
 * Интерфейс клиники.
 *
 * @author imataras
 * @since 10.09.2016
 */

public class ClinicUI {

    private final IClinic clinic;
    private final Validator validator;
    private final Map<Integer, Action> actions = new ConcurrentHashMap<Integer, Action>();

    public ClinicUI(final IClinic clinic, final Validator validator) {
        this.clinic = clinic;
        this.validator = validator;
    }

    /**
     * Добавить новое действие в клинику.
     *
     * @param action
     */

    public void loadAction(final Action action) {
        this.actions.put(action.key(), action);
    }

    public void show() {
        this.intro();
        do {
            doAction(validator);
        } while (validator.compare("Do you want to continue? (y)", "y"));
    }

    /**
     * Запросить выбрать действия пользователя и выполнить его.
     *
     * @param validator валидатор.
     */
    private void doAction(final Validator validator) {
        this.actions.get(
                validator.getIntFromList(
                        "Enter operation : ",
                        this.actions.keySet()
                )
        ).execute(this.clinic, validator);
    }

    private void intro() {
        System.out.println("Welcome to clinic");
        for (final Action action : this.actions.values()) {
            System.out.println(action.intro());
        }
    }

}
