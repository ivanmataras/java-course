package ru.imataras.clinic.actions;

import ru.imataras.interact.Validator;
import ru.imataras.clinic.IClinic;
import ru.imataras.clinic.actions.Action;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 19.09.2016
 */

public class DeleteClientAction implements Action {

    /**
     * Выполнить действие.
     *
     * @param clinic    Клиника.
     * @param validator Валидатор ввода.
     */
    @Override
    public void execute(IClinic clinic, Validator validator) {
        int clientId = validator.getInt("Select client ID : ");
        clinic.deleteClient(clientId);
    }

    /**
     * Описание действия.
     *
     * @return Описание.
     */
    @Override
    public String intro() {
        return String.format("%s - delete client", this.key());
    }

    /**
     * Ключ.
     *
     * @return ключ.
     */
    @Override
    public int key() {
        return 5;
    }

}
