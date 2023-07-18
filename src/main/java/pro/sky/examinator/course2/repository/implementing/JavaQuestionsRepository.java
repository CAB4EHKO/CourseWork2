package pro.sky.examinator.course2.repository.implementing;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class JavaQuestionsRepository extends AbstractRepository {
    @PostConstruct
    public void init() {
        add("Вопрос по Java - 1", "Ответ по Java - 1");
        add("Вопрос по Java - 2", "Ответ по Java - 2");
        add("Вопрос по Java - 3", "Ответ по Java - 3");
        add("Вопрос по Java - 4", "Ответ по Java - 4");
        add("Вопрос по Java - 5", "Ответ по Java - 5");
    }
}
