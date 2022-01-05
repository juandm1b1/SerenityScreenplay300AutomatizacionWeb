package tasks;

import models.PatRegData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.DocRegPage;
import userinterfaces.PatRegPage;

import java.util.List;

public class PatientReg implements Task {

    private final List<PatRegData> patRegData;

    public PatientReg(List<PatRegData> patRegData) {
        this.patRegData = patRegData;
    }

    public static PatientReg signUp(List<PatRegData> patRegData) {
        return Tasks.instrumented(PatientReg.class,patRegData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PatRegPage.ADD_PATIENT_OPTION),
                Enter.theValue(patRegData.get(0).getStrPatientFName()).into(PatRegPage.FIRSTNAME_INPUT),
                Enter.theValue(patRegData.get(0).getStrPatientLName()).into(PatRegPage.LASTNAME_INPUT),
                Enter.theValue(patRegData.get(0).getStrPatientPhone()).into(PatRegPage.PHONE_INPUT),
                Click.on(PatRegPage.docTypeOption(patRegData.get(0).getStrPatientDocType())),
                Enter.theValue(patRegData.get(0).getStrPatientDocument()).into(PatRegPage.DOCUMENT_INPUT)
        );
        if (patRegData.get(0).getBoolPrepaid().equals("true")){
            actor.attemptsTo(Click.on(PatRegPage.PREPAID_CHECKBOX));
        }
        actor.attemptsTo(Click.on(PatRegPage.SAVE_BUTTON));

    }
}
