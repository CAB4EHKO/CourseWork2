package pro.sky.examinator.course2.services.implementing;

import org.springframework.stereotype.Service;
import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.services.ExaminerService;

import java.util.Collection;
@Service
public class ExaminerServiceImpl implements ExaminerService {


    @Override
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
