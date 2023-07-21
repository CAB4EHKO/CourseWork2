package pro.sky.examinator.course2.repository;

import pro.sky.examinator.course2.entity.Question;

import java.util.Collection;

public interface QuestionsRepository {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    int size();
}
