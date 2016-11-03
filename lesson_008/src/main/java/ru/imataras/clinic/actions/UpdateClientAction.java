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

public class UpdateClientAction implements Action {

    /**
     * Выполнить действие.
     *
     * @param clinic    Клиника.
     * @param validator Валидатор ввода.
     */
    @Override
    public void execute(IClinic clinic, Validator validator) {
        final int clientId = validator.getInt("Select client ID : ");
        final String name = validator.getString("Enter client name : ");
        final Client client = clinic.getById(clientId);
        client.setName(name);
        clinic.editClient(client);
    }

    /**
     * Описание действия.
     *
     * @return Описание.
     */
    @Override
    public String intro() {
        return String.format("%s - update client", this.key());
    }

    /**
     * Ключ.
     *
     * @return ключ.
     */
    @Override
    public int key() {
        return 3;
    }

}
