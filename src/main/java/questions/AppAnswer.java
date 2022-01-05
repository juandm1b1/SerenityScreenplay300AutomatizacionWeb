package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.AppRegPage;


public class AppAnswer implements Question<Boolean> {

    private String question;

    public AppAnswer(String question) { this.question = question; }

    public static Question<Boolean> toThe(String strAppointmentMessage) { return new AppAnswer(strAppointmentMessage); }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String message = Text.of(AppRegPage.MESSAGE).viewedBy(actor).asString();

        if (question.equals(message) | message.contains(question)){
            result = true;
        } else {
            result = false;
        }
        return result;
    }
}
