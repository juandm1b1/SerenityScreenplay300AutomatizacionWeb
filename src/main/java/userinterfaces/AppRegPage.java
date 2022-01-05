package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AppRegPage extends PageObject {

    public static final Target ADD_APPOINTMENT_OPTION = Target.the("Add appointment option")
            .located(By.xpath("//a[@href='appointmentScheduling']"));
    public static final Target DATE_INPUT = Target.the("Input for entering the appointment date")
            .located(By.id("datepicker"));
    public static final Target PATIENT_DOC_INPUT = Target.the("Input for entering the patient's document")
            .located(By.xpath("//input[@placeholder='Ingrese el documento de identidad del paciente']"));
    public static final Target DOCTOR_DOC_INPUT = Target.the("Input for entering the doctor's document")
            .located(By.xpath("//input[@placeholder='Ingrese el documento de identidad del doctor']"));
    public static final Target OBSERVATIONS_INPUT = Target.the("Input for entering observations about the appointment")
            .located(By.xpath("//textarea"));
    public static final Target SAVEAPP_BUTTON = Target.the("Save scheduled appointment button")
            .located(By.xpath("//a[contains(text(),'Guardar')]"));

    public static final Target MESSAGE = Target.the("The successful appointment registration message")
            .located(By.xpath("//div[@class='panel-body']/p"));
}
