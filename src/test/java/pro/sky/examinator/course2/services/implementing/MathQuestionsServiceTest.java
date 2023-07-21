package pro.sky.examinator.course2.services.implementing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.exceptions.IncorrectQuestionOrAnswerException;
import pro.sky.examinator.course2.exceptions.QuestionNotFoundException;
import pro.sky.examinator.course2.exceptions.QuestionRepeatsAnswerException;
import pro.sky.examinator.course2.exceptions.QuestionsAreEmptyException;
import pro.sky.examinator.course2.repository.implementing.MathQuestionsRepository;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static pro.sky.examinator.course2.services.constants.QuestionConstants.*;

@ExtendWith(MockitoExtension.class)
public class MathQuestionsServiceTest {

    @Mock
    private MathQuestionsRepository repositoryMock;
    @InjectMocks
    private MathQuestionsService service;

    @Test
    @DisplayName("Must add Q&A as an object")
    void shouldAddQuestionAsObject() {
        when(repositoryMock.add(MATH_QUESTION1))
                .thenReturn(MATH_QUESTION1);
        Question actual = service.add(MATH_QUESTION1);
        Question expected = new Question(MATH_QUESTION_1, MATH_ANSWER_1);
        assertThat(actual)
                .isEqualTo(expected);
        verify(repositoryMock, times(1)).add(expected);
    }

    @Test
    @DisplayName("Must add question-answer passed as strings")
    void ShouldAddQuestionAsString() {
        when(repositoryMock.add(NEW_MATH_QUESTION_OBJ))
                .thenReturn(NEW_MATH_QUESTION_OBJ);
        Question actual = service.add(NEW_MATH_QUESTION, NEW_MATH_ANSWER);
        Question expected = new Question(NEW_MATH_QUESTION, NEW_MATH_ANSWER);
        assertThat(actual)
                .isEqualTo(expected);
        verify(repositoryMock, times(1)).add(expected);
    }

    @Test
    @DisplayName("Should delete Q&A")
    void removeQuestionTest() {
        when(repositoryMock.remove(eq(MATH_QUESTION1)))
                .thenReturn(MATH_QUESTION1);
        assertEquals(MATH_QUESTION1, service.remove(MATH_QUESTION1));
        verify(repositoryMock, times(1)).remove(MATH_QUESTION1);
    }

    @Test
    @DisplayName("Should throw an exception when deleting a Q&A")
    void removeNegativeQuestionTest() {
        Question question = new Question(null, MATH_ANSWER_2);
        assertThatExceptionOfType(IncorrectQuestionOrAnswerException.class)
                .isThrownBy(() -> service.remove(question));
    }

    @Test
    @DisplayName("Should throw an exception when deleting a Q&A")
    void removeNegative2QuestionTest() {
        Question question = new Question(MATH_QUESTION_3, MATH_QUESTION_3);
        assertThatExceptionOfType(QuestionRepeatsAnswerException.class)
                .isThrownBy(() -> service.remove(question));
    }

    @Test
    @DisplayName("Should get all elements of the collection")
    void getAllTest() {
        when(repositoryMock.getAll())
                .thenReturn(MATH_QUESTIONS);
        assertEquals(MATH_QUESTIONS, service.getAll());
    }

    @Test
    @DisplayName("Must confirm that the collection is empty")
    void getAllTestWhenCollectionIsEmpty() {
        when(repositoryMock.getAll())
                .thenReturn(emptyList());
        assertTrue(service.getAll().isEmpty());
    }

    @Test
    @DisplayName("Should get a random question")
    void getRandomQuestionTest() {
        when(repositoryMock.size()).thenReturn(5);
        when(repositoryMock.getAll()).thenReturn(MATH_QUESTIONS);

        Question randomQuestion = service.getRandomQuestion();

        assertThat(randomQuestion)
                .isIn(MATH_QUESTIONS)
                .isNotNull();
    }

    @Test
    @DisplayName("Should throw an exception when asked randomly")
    void getRandomQuestionNegativeTest() {
        assertThatExceptionOfType(QuestionsAreEmptyException.class)
                .isThrownBy(service::getRandomQuestion);
    }

    @Test
    public void shouldCallThrowExceptionInMathQuestionServiceRemove() {
        Question remove = new Question(NEW_MATH_QUESTION, NEW_MATH_ANSWER);
        when(repositoryMock.remove(remove))
                .thenThrow(new QuestionNotFoundException());
        assertThrows(QuestionsAreEmptyException.class, () -> service.getRandomQuestion());
        assertThrows(QuestionNotFoundException.class, () -> service.remove(remove));
    }

}
