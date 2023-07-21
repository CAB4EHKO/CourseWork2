package pro.sky.examinator.course2.services;

import pro.sky.examinator.course2.entity.Question;

import java.util.Collection;

public interface QuestionService {

    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestions();

    Question getRandomQuestion();

    int size();
}
