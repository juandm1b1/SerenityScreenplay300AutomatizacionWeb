package tasks;

import models.DocRegData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import userinterfaces.DocRegPage;

import java.util.List;

public class DoctorReg implements Task {

    private final List<DocRegData> docRegData;

    public DoctorReg(List<DocRegData> docRegData) {
        this.docRegData = docRegData;
    }

    public static DoctorReg signUp(List<DocRegData> docRegData) {
        return Tasks.instrumented(DoctorReg.class,docRegData);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DocRegPage.ADD_DOCTOR_OPTION),
                Enter.theValue(docRegData.get(0).getStrDoctorFName()).into(DocRegPage.FIRSTNAME_INPUT),
                Enter.theValue(docRegData.get(0).getStrDoctorLName()).into(DocRegPage.LASTNAME_INPUT),
                Enter.theValue(docRegData.get(0).getStrDoctorPhone()).into(DocRegPage.PHONE_INPUT),
                Click.on(DocRegPage.docTypeOption(docRegData.get(0).getStrDoctorDocType())),
                Enter.theValue(docRegData.get(0).getStrDoctorDocument()).into(DocRegPage.DOCUMENT_INPUT),
                Click.on(DocRegPage.SAVE_BUTTON)
        );
    }
}
