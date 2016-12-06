package ru.imataras.sync;

import ru.imataras.clinic.ClinicUI;
import ru.imataras.clinic.IClinic;
import ru.imataras.clinic.actions.Action;
import ru.imataras.clinic.actions.CreateClientAction;
import ru.imataras.clinic.actions.ShowAction;

/**
 * TODO: comment
 *
 * @author imataras
 * @since 07.12.2016
 */

public class EmulateUsers {

    public static void main(String[] args) {
        new EmulateUsers().startActivities();
    }

    public void startActivities() {
        IClinic clinic = new SynchClinic();
        new EmulateUserActivities(
                this.build(
                        clinic,
                        new String[]{"0", "yes"},
                        new ShowAction()
                )
        ).start();
        new EmulateUserActivities(
                this.build(
                        clinic,
                        new String[]{"1", "Petr", "yes"},
                        new CreateClientAction()
                )
        ).start();
    }

    public ClinicUI build(IClinic clinic, String[] anwers, Action... actions) {
        ClinicUI ui = new ClinicUI(
                clinic,
                new StubInput(anwers)
        );
        for (Action action : actions) {
            ui.loadAction(action);
        }
        return ui;
    }

}
