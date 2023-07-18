package pro.sky.examinator.course2.services.implementing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.repository.QuestionsRepository;

@Service
public class MathQuestionsService extends AbstractService {
    @Autowired
    public MathQuestionsService(@Qualifier("mathQuestionsRepository") final QuestionsRepository questionRepository) {
        super(questionRepository);
    }

    @Override
    public Question getRandomQuestions() {
        return null;
    }
}
