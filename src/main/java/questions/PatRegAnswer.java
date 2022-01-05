package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.PatRegPage;


public class PatRegAnswer implements Question<Boolean> {

    private String question;

    public PatRegAnswer(String question) { this.question = question; }

    public static Question<Boolean> toThe(String strPatientMessage) { return new DocRegAnswer(strPatientMessage); }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String message = Text.of(PatRegPage.MESSAGE).viewedBy(actor).asString();

        System.out.println("message: " + message);
        System.out.println("question: " + question);

        if (question.equals(message) | message.contains(question)){
            result = true;
        }else{
            result = false;
        }
        return result;
    }
}
