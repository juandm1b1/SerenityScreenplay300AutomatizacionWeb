package stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.AppRegData;
import models.DocRegData;
import models.PatRegData;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.AppAnswer;
import questions.DocRegAnswer;
import questions.PatRegAnswer;
import tasks.AppointmentReg;
import tasks.OpenUp;
import tasks.DoctorReg;
import tasks.PatientReg;

import java.util.List;

public class MedApStepDefinitions {

    @Before
    public void setTheStage(){ OnStage.setTheStage(new OnlineCast());}

    @Given("^that Carlos needs to register a doctor$")
    public void thatCarlosNeedsToRegisterADoctor() {
        OnStage.theActorCalled("Carlos").wasAbleTo(OpenUp.thePage());
    }

    @When("^he makes the doctor registration on the Hospitals Administration System$")
    public void heMakesTheDoctorRegistrationOnTheHospitalsAdministrationSystem(List<DocRegData> docRegData) {
        OnStage.theActorInTheSpotlight().attemptsTo(DoctorReg.signUp(docRegData));
    }

    @Then("^he verifies the successful doctor registration message$")
    public void heVerifiesTheSuccessfulDoctorRegistrationMessage(List<DocRegData> docRegData) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(DocRegAnswer.toThe(docRegData.get(0).getStrDoctorMessage())));
    }
// °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
    @Given("^that Carlos needs to register a patient$")
    public void thatCarlosNeedsToRegisterAPatient() {
        OnStage.theActorCalled("Carlos").wasAbleTo(OpenUp.thePage());
    }

    @When("^he makes the patient registration on the Hospitals Administration System$")
    public void heMakesThePatientRegistrationOnTheHospitalsAdministrationSystem(List<PatRegData> patRegData) {
        OnStage.theActorInTheSpotlight().attemptsTo(PatientReg.signUp(patRegData));
    }

    @Then("^he verifies the successful patient registration message$")
    public void heVerifiesTheSuccessfulPatientRegistrationMessage(List<PatRegData> patRegData) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(PatRegAnswer.toThe(patRegData.get(0).getStrPatientMessage())));
    }

    @Given("^that Carlos needs to go to the doctor$")
    public void thatCarlosNeedsToGoToTheDoctor() {
        OnStage.theActorCalled("Carlos").wasAbleTo(OpenUp.thePage());
    }

    @When("^he request a medical appointment$")
    public void heRequestAMedicalAppointment(List<AppRegData> appRegData) {
        OnStage.theActorInTheSpotlight().attemptsTo(AppointmentReg.makeApp(appRegData));
    }

    @Then("^he verifies the successful appointment request message$")
    public void heVerifiesTheSuccessfulAppointmentRequestMessage(List<AppRegData> appRegData) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(AppAnswer.toThe(appRegData.get(0).getStrAppointmentMessage())));
    }
}
