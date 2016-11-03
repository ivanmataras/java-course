package ru.imataras.clinic;

import ru.imataras.clinic.actions.CreateClientAction;
import ru.imataras.clinic.actions.CreatePetAction;
import ru.imataras.clinic.actions.DeleteClientAction;
import ru.imataras.clinic.actions.DeletePetAction;
import ru.imataras.clinic.actions.SearchClientAction;
import ru.imataras.clinic.actions.SearchPetAction;
import ru.imataras.clinic.actions.ShowAction;
import ru.imataras.clinic.actions.UpdateClientAction;
import ru.imataras.clinic.actions.UpdatePetAction;
import ru.imataras.interact.ConsoleIO;
import ru.imataras.interact.Validator;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * main calss
 *
 * @autor imataras
 * @since 10.09.2016
 */

public class ClinicRunner {

    public static void main(String[] args) {

        final ClinicUI ui = new ClinicUI(
                new Clinic(),
                new Validator(
                        new ConsoleIO(
                                new Scanner(System.in),
                                System.out)
                )
        );

        ui.loadAction(new ShowAction());
        ui.loadAction(new CreateClientAction());
        ui.loadAction(new CreatePetAction());
        ui.loadAction(new UpdateClientAction());
        ui.loadAction(new UpdatePetAction());
        ui.loadAction(new DeleteClientAction());
        ui.loadAction(new DeletePetAction());
        ui.loadAction(new SearchClientAction());
        ui.loadAction(new SearchPetAction());
        ui.show();

    }
}
