package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class PatRegPage extends PageObject {

    public static final Target ADD_PATIENT_OPTION = Target.the("Add doctor option")
            .located(By.xpath("//a[@href='addPatient']"));
    public static final Target FIRSTNAME_INPUT = Target.the("Input for entering doctor's firstname")
            .located(By.name("name"));
    public static final Target LASTNAME_INPUT = Target.the("Input for entering doctor's lastname")
            .located(By.name("last_name"));
    public static final Target PHONE_INPUT = Target.the("Input for entering doctor's phone number")
            .located(By.name("telephone"));

    public static Target docTypeOption(String docType){
        return Target.the("Select the document type from the list").located(By.name("identification_type"));
    }

    public static final Target DOCUMENT_INPUT = Target.the("Input for entering doctor's document")
            .located(By.name("identification"));
    public static final Target PREPAID_CHECKBOX = Target.the("Checkbox for indicating if the patient has prepaid healtcare")
            .located(By.name("prepaid"));

    public static final Target SAVE_BUTTON = Target.the("Save doctor registration button")
            .located(By.xpath("//a[contains(text(),'Guardar')]"));

    public static final Target MESSAGE = Target.the("The successful doctor registration message")
            .located(By.xpath("//div[@class='panel-body']/p"));
}