package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import userinterfaces.DocRegPage;

public class DocRegAnswer implements Question<Boolean> {

    private String question;

    public DocRegAnswer(String question) { this.question = question; }

    public static Question<Boolean> toThe(String strDoctorMessage) { return new DocRegAnswer(strDoctorMessage); }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String message = Text.of(DocRegPage.MESSAGE).viewedBy(actor).asString();

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
