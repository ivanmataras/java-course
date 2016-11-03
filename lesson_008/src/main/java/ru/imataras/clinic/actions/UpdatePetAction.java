package ru.imataras.clinic.actions;

import ru.imataras.interact.Validator;
import ru.imataras.clinic.Client;
import ru.imataras.clinic.IClinic;
import ru.imataras.clinic.Pet;
import ru.imataras.clinic.actions.Action;
import ru.imataras.interact.Validator;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 19.09.2016
 */

public class UpdatePetAction implements Action {

    /**
     * Выполнить действие.
     *
     * @param clinic    Клиника.
     * @param validator Валидатор ввода.
     */
    @Override
    public void execute(IClinic clinic, Validator validator) {
        final int clientId = validator.getInt("Select client ID : ");
        final int petId = validator.getInt("Select pet ID : ");
        final String name = validator.getString("Enter pet nick : ");
        final Client client = clinic.getById(clientId);
        Pet pet = client.getPetById(petId);
        pet.setName(name);
        client.editPet(pet);
    }

    /**
     * Описание действия.
     *
     * @return Описание.
     */
    @Override
    public String intro() {
        return String.format("%s - update pet", this.key());
    }

    /**
     * Ключ.
     *
     * @return ключ.
     */
    @Override
    public int key() {
        return 4;
    }

}
