package pro.sky.examinator.course2.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.examinator.course2.repository.implementing.JavaQuestionsRepository;
import pro.sky.examinator.course2.repository.implementing.MathQuestionsRepository;
import pro.sky.examinator.course2.services.implementing.ExaminerServiceImpl;
import pro.sky.examinator.course2.services.implementing.JavaQuestionsService;
import pro.sky.examinator.course2.services.implementing.MathQuestionsService;

import static pro.sky.examinator.course2.services.constants.QuestionConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceTest {

    @Mock
    private JavaQuestionsService javaQuestionsService = new JavaQuestionsService(new JavaQuestionsRepository());
    @Mock
    private MathQuestionsService mathQuestionsService = new MathQuestionsService(new MathQuestionsRepository());
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    @DisplayName("Must confirm a random JAVA question is being generated")
    void containsJavaQuestionTest() {
        when(javaQuestionsService.size()).thenReturn(5);
        when(javaQuestionsService.getRandomQuestion())
                .thenReturn(QUESTION1, QUESTION2, QUESTION3, QUESTION1, QUESTION4, QUESTION5);
        assertThat(examinerService.getQuestions(1))
                .contains(QUESTION1);
    }

    @Test
    @DisplayName("Must confirm that a random Math question is being generated")
    void containsMathQuestionTest() {
        when(mathQuestionsService.size()).thenReturn(5);
        when(mathQuestionsService.getRandomQuestion())
                .thenReturn(MATH_QUESTION1, MATH_QUESTION2, MATH_QUESTION3, MATH_QUESTION4, MATH_QUESTION5, MATH_QUESTION1);
        assertThat(examinerService.getQuestions(1))
                .contains(MATH_QUESTION1);
    }


}
