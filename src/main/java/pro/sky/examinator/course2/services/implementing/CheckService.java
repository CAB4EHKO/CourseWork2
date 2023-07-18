package pro.sky.examinator.course2.services.implementing;

import org.springframework.stereotype.Service;
import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.exceptions.IncorrectQuestionOrAnswerException;
import pro.sky.examinator.course2.exceptions.QuestionRepeatsAnswerException;

@Service
public class CheckService {
    public Question checkQuestion(String question, String answer) {
        if (question == null || answer == null) {
            throw new IncorrectQuestionOrAnswerException();
        }
        if (question.equals(answer)) {
            throw new QuestionRepeatsAnswerException();
        }
        return new Question(question, answer);
    }
}
