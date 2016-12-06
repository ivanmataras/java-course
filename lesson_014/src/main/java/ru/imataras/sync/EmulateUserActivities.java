package ru.imataras.sync;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.imataras.clinic.ClinicUI;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 * @author imataras
 * @since 06.12.2016
 */

public class EmulateUserActivities extends Thread {

    private final ClinicUI ui;

    public EmulateUserActivities(ClinicUI ui) {
        this.ui = ui;
    }

    @Override
    public void run() {
        ui.show();
    }

}
