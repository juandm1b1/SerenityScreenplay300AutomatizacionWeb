package userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DocRegPage extends PageObject {

    public static final Target ADD_DOCTOR_OPTION = Target.the("Add doctor option")
            .located(By.xpath("//a[@href='addDoctor']"));
    public static final Target FIRSTNAME_INPUT = Target.the("Input for entering doctor's firstname")
            .located(By.id("name"));
    public static final Target LASTNAME_INPUT = Target.the("Input for entering doctor's lastname")
            .located(By.id("last_name"));
    public static final Target PHONE_INPUT = Target.the("Input for entering doctor's phone number")
            .located(By.id("telephone"));

    public static Target docTypeOption(String docType){
        return Target.the("Select the document type from the list")
                .located(By.xpath("//select[@id='identification_type']/option[@value='"+ docType +"']"));
    }

    public static final Target DOCUMENT_INPUT = Target.the("Input for entering doctor's document")
            .located(By.id("identification"));
    public static final Target SAVE_BUTTON = Target.the("Save doctor registration button")
            .located(By.xpath("//a[contains(text(),'Guardar')]"));

//    public static final Target MESSAGE = Target.the("The successful doctor registration message")
//            .located(By.xpath("//div[@class='panel-body']/p[contains(text(),'Datos guardados correctamente.')]"));

    public static final Target MESSAGE = Target.the("The successful or failed doctor registration message")
            .located(By.xpath("//div[@class='panel-body']/p"));
}
