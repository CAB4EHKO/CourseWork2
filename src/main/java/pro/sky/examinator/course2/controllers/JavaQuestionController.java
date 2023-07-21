package pro.sky.examinator.course2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.repository.QuestionsRepository;
import pro.sky.examinator.course2.services.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/java")
public class JavaQuestionController {

    private final QuestionService service;

    @Autowired

    public JavaQuestionController(@Qualifier("javaQuestionsService") QuestionService service) {
        this.service = service;
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(name = "question") String question,
                                @RequestParam(name = "answer") String answer
    ) {
        return service.add(question, answer);
    }
    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(name = "question") String question,
                                   @RequestParam(name = "answer") String answer
    ) {
        return service.remove(new Question(question, answer));
    }


}
