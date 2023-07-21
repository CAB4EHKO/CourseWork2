package pro.sky.examinator.course2.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.exceptions.QuestionAlreadyExistsException;
import pro.sky.examinator.course2.exceptions.QuestionNotFoundException;
import pro.sky.examinator.course2.repository.implementing.JavaQuestionsRepository;

import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static pro.sky.examinator.course2.services.constants.QuestionConstants.*;

public class JavaQuestionsRepositoryTest {
    private final JavaQuestionsRepository out = new JavaQuestionsRepository();

    @BeforeEach
    void setUp() {
        out.add(QUESTION1);
        out.add(QUESTION2);
        out.add(QUESTION3);
        out.add(QUESTION4);
        out.add(QUESTION5);
    }

    @AfterEach
    void afterEach() {
        new HashSet<>(out.getAll()).forEach(out::remove);
    }

    @Test
    void initTest() {
        assertThat(out.getAll()).isEqualTo(QUESTIONS);
    }

    @Test
    void addTest() {
        int beforeAdd = out.getAll().size();

        Question expected = new Question(NEW_QUESTION, NEW_ANSWER);

        assertThat(out.add(NEW_QUESTION_OBJ))
                .isEqualTo(expected)
                .isIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeAdd + 1);
    }

    @Test
    @DisplayName("Should throw an exception when adding an existing Q&A")
    void addNegativeTest() {
        Question expected = new Question(QUESTION_1, ANSWER_1);

        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(() -> out.add(expected));
    }

    @Test
    @DisplayName("Should add a question-answer passed as a new object")
    void addQuestionTest() {
        int beforeAdd = out.getAll().size();

        Question expected = NEW_QUESTION_OBJ;

        assertThat(out.add(expected))
                .isEqualTo(expected)
                .isIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeAdd + 1);
    }

    @Test
    @DisplayName("Should throw an exception when adding a question-answer passed as a new object")
    void addNegativeQuestionTest() {
        assertThatExceptionOfType(QuestionAlreadyExistsException.class)
                .isThrownBy(() -> out.add(new Question(QUESTION_1, ANSWER_1)));
    }

    @Test
    void removeTest() {
        int beforeRemove = out.getAll().size();

        Question expected = new Question(QUESTION_1, ANSWER_1);

        assertThat(out.remove(expected))
                .isEqualTo(expected)
                .isNotIn(out.getAll());

        assertThat(out.getAll().size()).isEqualTo(beforeRemove - 1);
    }

    @Test
    @DisplayName("Should throw an exception when deleting a Q&A")
    void removeNegativeTest() {
        Question expected = new Question(NEW_QUESTION, NEW_ANSWER);

        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() -> out.remove(expected));
    }

    @Test
    void getAllTest() {
        assertThat(out.getAll().size())
                .isEqualTo(5)
                .isSameAs(QUESTIONS.size());

        assertThat(out.getAll()).isEqualTo(QUESTIONS);
    }

    @Test
    void getAllNotNullTest() {
        assertThat(out.getAll())
                .isNotNull();
    }

}
