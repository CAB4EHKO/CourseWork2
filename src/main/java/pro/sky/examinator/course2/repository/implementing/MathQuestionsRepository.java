package pro.sky.examinator.course2.repository.implementing;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class MathQuestionsRepository extends AbstractRepository {
    @PostConstruct
    public void init() {
        add("2 + 2", "4");
        add("5 - 4", "1");
        add("8 / 4", "2");
        add("3 * 3", "9");
    }
}
