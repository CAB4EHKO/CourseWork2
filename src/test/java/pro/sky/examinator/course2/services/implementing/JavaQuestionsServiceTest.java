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
import pro.sky.examinator.course2.repository.implementing.JavaQuestionsRepository;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.mockito.Mockito.when;
import static pro.sky.examinator.course2.services.constants.QuestionConstants.*;
@ExtendWith(MockitoExtension.class)
public class JavaQuestionsServiceTest {

    @Mock
    private JavaQuestionsRepository repositoryMock;
    @InjectMocks
    private JavaQuestionsService service;

    @Test
    @DisplayName("Must add Q&A as an object")
    void shouldAddQuestionAsObject() {
        when(repositoryMock.add(QUESTION1))
                .thenReturn(QUESTION1);
        Question actual = service.add(QUESTION1);
        Question expected = new Question(QUESTION_1, ANSWER_1);
        assertThat(actual)
                .isEqualTo(expected);
        verify(repositoryMock, times(1)).add(expected);
    }

    @Test
    @DisplayName("Must add question-answer passed as strings")
    void ShouldAddQuestionAsString() {
        when(repositoryMock.add(NEW_QUESTION_OBJ))
                .thenReturn(NEW_QUESTION_OBJ);
        Question actual = service.add(NEW_QUESTION, NEW_ANSWER);
        Question expected = new Question(NEW_QUESTION, NEW_ANSWER);
        assertThat(actual)
                .isEqualTo(expected);
        verify(repositoryMock, times(1)).add(expected);
    }

    @Test
    @DisplayName("Should delete Q&A")
    void removeQuestionTest() {
        when(repositoryMock.remove(eq(QUESTION1)))
                .thenReturn(QUESTION1);
        assertEquals(QUESTION1, service.remove(QUESTION1));
        verify(repositoryMock, times(1)).remove(QUESTION1);
    }

    @Test
    @DisplayName("Should throw an exception when deleting a Q&A")
    void removeNegativeQuestionTest() {
        Question question = new Question(null, ANSWER_2);
        assertThatExceptionOfType(IncorrectQuestionOrAnswerException.class)
                .isThrownBy(() -> service.remove(question));
    }

    @Test
    @DisplayName("Should throw an exception when deleting a Q&A")
    void removeNegative2QuestionTest() {
        Question question = new Question(QUESTION_3, QUESTION_3);
        assertThatExceptionOfType(QuestionRepeatsAnswerException.class)
                .isThrownBy(() -> service.remove(question));
    }

    @Test
    @DisplayName("Should get all elements of the collection")
    void getAllTest() {
        when(repositoryMock.getAll())
                .thenReturn(QUESTIONS);
        assertEquals(QUESTIONS, service.getAll());
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
        when(repositoryMock.getAll()).thenReturn(QUESTIONS);

        Question randomQuestion = service.getRandomQuestion();

        assertThat(randomQuestion)
                .isIn(QUESTIONS)
                .isNotNull();
    }

    @Test
    @DisplayName("Should throw an exception when asked randomly")
    void getRandomQuestionNegativeTest() {
        assertThatExceptionOfType(QuestionsAreEmptyException.class)
                .isThrownBy(service::getRandomQuestion);
    }

    @Test
    public void shouldCallThrowExceptionInJavaQuestionServiceRemove() {
        Question remove = new Question(NEW_QUESTION, NEW_ANSWER);
        when(repositoryMock.remove(remove))
                .thenThrow(new QuestionNotFoundException());
        assertThrows(QuestionsAreEmptyException.class, () -> service.getRandomQuestion());
        assertThrows(QuestionNotFoundException.class, () -> service.remove(remove));
    }

}
