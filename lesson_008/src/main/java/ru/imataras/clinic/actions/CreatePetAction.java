package ru.imataras.clinic.actions;

import ru.imataras.interact.Validator;
import ru.imataras.clinic.Cat;
import ru.imataras.clinic.Dog;
import ru.imataras.clinic.IClinic;
import ru.imataras.clinic.Pet;
import ru.imataras.clinic.actions.Action;

import java.util.Arrays;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 19.09.2016
 */

public class CreatePetAction implements Action {

    /**
     * Выполнить действие.
     *
     * @param clinic    Клиника.
     * @param validator Валидатор ввода.
     */
    @Override
    public void execute(IClinic clinic, Validator validator) {
        int clientId = validator.getInt("Select client ID : ");
        int type = validator.getIntFromList("Select pet - 1. Dog, 2. Cat, : ", Arrays.asList(1, 2));
        String nick = validator.getString("Enter pet name : ");
        Pet pet = type == 1 ? new Dog(nick) : new Cat(nick);
        clinic.addPet(clientId, pet);
    }

    /**
     * Описание действия.
     *
     * @return Описание.
     */
    @Override
    public String intro() {
        return String.format("%s - create pet", this.key());
    }

    /**
     * Ключ.
     *
     * @return ключ.
     */
    @Override
    public int key() {
        return 2;
    }

}
