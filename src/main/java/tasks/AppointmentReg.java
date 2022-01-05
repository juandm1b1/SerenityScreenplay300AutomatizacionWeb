package tasks;

import models.AppRegData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.AppRegPage;

import java.util.List;

public class AppointmentReg implements Task {

    private List<AppRegData> appRegData;

    public AppointmentReg(List<AppRegData> appRegData) {
        this.appRegData = appRegData;
    }

    public static AppointmentReg makeApp(List<AppRegData> appRegData) {
        return Tasks.instrumented(AppointmentReg.class,appRegData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AppRegPage.ADD_APPOINTMENT_OPTION),
                Enter.theValue(appRegData.get(0).getStrAppointmentDate()).into(AppRegPage.DATE_INPUT),
                Enter.theValue(appRegData.get(0).getStrPatientDoc()).into(AppRegPage.PATIENT_DOC_INPUT),
                Enter.theValue(appRegData.get(0).getStrDoctorDoc()).into(AppRegPage.DOCTOR_DOC_INPUT),
                Enter.theValue(appRegData.get(0).getStrObservations()).into(AppRegPage.OBSERVATIONS_INPUT),
                Click.on(AppRegPage.SAVEAPP_BUTTON)
        );
    }
}
