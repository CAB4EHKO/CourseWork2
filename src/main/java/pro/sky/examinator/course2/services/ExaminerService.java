package pro.sky.examinator.course2.services;

import pro.sky.examinator.course2.entity.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);

}
