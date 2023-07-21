package pro.sky.examinator.course2.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.exceptions.QuestionAlreadyExistsException;
import pro.sky.examinator.course2.exceptions.QuestionNotFoundException;
import static pro.sky.examinator.course2.services.constants.QuestionConstants.*;


import java.util.HashSet;


import org.junit.jupiter.api.DisplayName;
import pro.sky.examinator.course2.repository.implementing.MathQuestionsRepository;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class MathQuestionsRepositoryTest {

    private final MathQuestionsRepository out = new MathQuestionsRepository();

    @BeforeEach
    void setUp() {
        out.add(MATH_QUESTION1);
        out.add(MATH_QUESTION2);
        out.add(MATH_QUESTION3);
        out.add(MATH_QUESTION4);
        out.add(MATH_QUESTION5);
    }

    @AfterEach
    void afterEach() {
        new HashSet<>(out.getAll()).forEach(out::remove);
    }

    @Test
    void initTest() {
        assertThat(out.getAll()).isEqualTo(MATH_QUESTIONS);
    }

    @Test
    void addTest() {
        int beforeAdd = out.getAll().size();

        Question expected = new Question(NEW_MATH_QUESTION, NEW_MATH_ANSWER);

        assertThat(out.add(NEW_MATH_QUESTION_OBJ))
                .isEqualTo(expected)
                .isIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeAdd + 1);
    }

    @Test
    @DisplayName("Should throw an exception when adding an existing Q&A")
    void addNegativeTest() {
        Question expected = new Question(MATH_QUESTION_1, MATH_ANSWER_1);

        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(() -> out.add(expected));
    }

    @Test
    @DisplayName("Should add a question-answer passed as a new object")
    void addQuestionTest() {
        int beforeAdd = out.getAll().size();

        Question expected = NEW_MATH_QUESTION_OBJ;

        assertThat(out.add(expected))
                .isEqualTo(expected)
                .isIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeAdd + 1);
    }

    @Test
    @DisplayName("Should throw an exception when adding a question-answer passed as a new object")
    void addNegativeQuestionTest() {
        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(() -> out.add(new Question(MATH_QUESTION_1, MATH_ANSWER_1)));
    }

    @Test
    void removeTest() {
        int beforeRemove = out.getAll().size();

        Question expected = new Question(MATH_QUESTION_1, MATH_ANSWER_1);

        assertThat(out.remove(expected))
                .isEqualTo(expected)
                .isNotIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeRemove - 1);
    }

    @Test
    @DisplayName("Should throw an exception when deleting a Q&A")
    void removeNegativeTest() {
        Question expected = new Question(NEW_MATH_QUESTION, NEW_MATH_ANSWER);

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.remove(expected));
    }

    @Test
    void getAllTest() {
        assertThat(out.getAll().size())
                .isEqualTo(5)
                .isSameAs(MATH_QUESTIONS.size());

        assertThat(out.getAll()).isEqualTo(MATH_QUESTIONS);
    }

    @Test
    void getAllNotNullTest() {
        assertThat(out.getAll())
                .isNotNull();
    }

}
