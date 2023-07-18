package pro.sky.examinator.course2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.examinator.course2.entity.Question;
import pro.sky.examinator.course2.services.ExaminerService;

import java.util.Collection;

@RestController
public class ExaminerController {

    private final ExaminerService service;

    @Autowired
    public ExaminerController(ExaminerService service) {
        this.service = service;
    }

    @GetMapping(path = "/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable(name = "amount") int amount) {
        return service.getQuestions(amount);
    }
}
