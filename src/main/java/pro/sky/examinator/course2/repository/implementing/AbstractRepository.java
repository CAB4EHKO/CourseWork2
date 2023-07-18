package pro.sky.examinator.course2.repository.implementing;

import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.exceptions.QuestionAlreadyExistsException;
import pro.sky.examinator.course2.exceptions.QuestionNotFoundException;
import pro.sky.examinator.course2.repository.QuestionsRepository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class AbstractRepository implements QuestionsRepository {
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(final String question, final String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(final Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(final Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }

    @Override
    public int size() {
        return questions.size();
    }
}
