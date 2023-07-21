package pro.sky.examinator.course2.services.implementing;

import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.exceptions.QuestionsAreEmptyException;
import pro.sky.examinator.course2.repository.QuestionsRepository;
import pro.sky.examinator.course2.services.QuestionService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public abstract class AbstractService implements QuestionService {
    private final QuestionsRepository questionRepository;
    private final CheckService checkService;
    private final Random random;

    public AbstractService(final QuestionsRepository questionRepository
    ) {
        this.random = new Random();
        this.questionRepository = questionRepository;
        this.checkService = new CheckService();
    }

    @Override
    public Question add(String question, String answer) {
        Question q = checkService.checkQuestion(question, answer);
        return questionRepository.add(q);
    }

    @Override
    public Question add(Question question) {
        Question q = checkService.checkQuestion(question.getQuestion(), question.getAnswer());
        return questionRepository.add(q);
    }

    @Override
    public Question remove(Question question) {
        Question q = checkService.checkQuestion(question.getQuestion(), question.getAnswer());
        return questionRepository.remove(q);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        if (questionRepository.size() == 0) {
            throw new QuestionsAreEmptyException();
        }
        Collection<Question> questions = getAll();
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }

    @Override
    public int size() {
        return questionRepository.size();
    }

}
