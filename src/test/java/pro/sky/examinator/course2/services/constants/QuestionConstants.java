package pro.sky.examinator.course2.services.constants;

import pro.sky.examinator.course2.entity.Question;

import java.util.Collection;
import java.util.Set;

public class QuestionConstants {

    public static final String QUESTION_1 = "Question1";
    public static final String QUESTION_2 = "Question2";
    public static final String QUESTION_3 = "Question3";
    public static final String QUESTION_4 = "Question4";
    public static final String QUESTION_5 = "Question5";
    public static final String NEW_QUESTION = "New Question";

    public static final String ANSWER_1 = "Answer1";
    public static final String ANSWER_2 = "Answer2";
    public static final String ANSWER_3 = "Answer3";
    public static final String ANSWER_4 = "Answer4";
    public static final String ANSWER_5 = "Answer5";
    public static final String NEW_ANSWER = "New Answer";

    public static final String MATH_QUESTION_1 = "2 * 2";
    public static final String MATH_QUESTION_2 = "3 + 2";
    public static final String MATH_QUESTION_3 = "10 - 2";
    public static final String MATH_QUESTION_4 = "90 / 5";
    public static final String MATH_QUESTION_5 = "5 % 3";
    public static final String NEW_MATH_QUESTION = "3 ^ 2";

    public static final String MATH_ANSWER_1 = "4";
    public static final String MATH_ANSWER_2 = "5";
    public static final String MATH_ANSWER_3 = "8";
    public static final String MATH_ANSWER_4 = "18";
    public static final String MATH_ANSWER_5 = "2";
    public static final String NEW_MATH_ANSWER = "9";

    public static final Question QUESTION1 = new Question(QUESTION_1, ANSWER_1);
    public static final Question QUESTION2 = new Question(QUESTION_2, ANSWER_2);
    public static final Question QUESTION3 = new Question(QUESTION_3, ANSWER_3);
    public static final Question QUESTION4 = new Question(QUESTION_4, ANSWER_4);
    public static final Question QUESTION5 = new Question(QUESTION_5, ANSWER_5);
    public static final Question NEW_QUESTION_OBJ = new Question(NEW_QUESTION, NEW_ANSWER);
    public static final Question NEW_MATH_QUESTION_OBJ = new Question(NEW_MATH_QUESTION, NEW_MATH_ANSWER);

    public static final Question MATH_QUESTION1 = new Question(MATH_QUESTION_1, MATH_ANSWER_1);
    public static final Question MATH_QUESTION2 = new Question(MATH_QUESTION_2, MATH_ANSWER_2);
    public static final Question MATH_QUESTION3 = new Question(MATH_QUESTION_3, MATH_ANSWER_3);
    public static final Question MATH_QUESTION4 = new Question(MATH_QUESTION_4, MATH_ANSWER_4);
    public static final Question MATH_QUESTION5 = new Question(MATH_QUESTION_5, MATH_ANSWER_5);

    public static final Collection<Question> QUESTIONS = Set.of(
            QUESTION1,
            QUESTION2,
            QUESTION3,
            QUESTION4,
            QUESTION5
    );

    public static final Collection<Question> MATH_QUESTIONS = Set.of(
            MATH_QUESTION1,
            MATH_QUESTION2,
            MATH_QUESTION3,
            MATH_QUESTION4,
            MATH_QUESTION5
    );

}
