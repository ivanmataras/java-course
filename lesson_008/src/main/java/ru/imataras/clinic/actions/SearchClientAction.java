package ru.imataras.clinic.actions;

import ru.imataras.interact.Validator;
import ru.imataras.clinic.Client;
import ru.imataras.clinic.IClinic;
import ru.imataras.clinic.actions.Action;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 19.09.2016
 */

public class SearchClientAction implements Action {

    /**
     * Выполнить действие.
     *
     * @param clinic    Клиника.
     * @param validator Валидатор ввода.
     */
    @Override
    public void execute(IClinic clinic, Validator validator) {
        String key = validator.getString("Search client by name : ");
        for (Client client : clinic.searchClient(key)) {
            System.out.println(client);
        }
    }

    /**
     * Описание действия.
     *
     * @return Описание.
     */
    @Override
    public String intro() {
        return String.format("%s - search client", this.key());
    }

    /**
     * Ключ.
     *
     * @return ключ.
     */
    @Override
    public int key() {
        return 7;
    }

}
