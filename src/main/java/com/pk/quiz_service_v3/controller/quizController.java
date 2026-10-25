package com.pk.quiz_service_v3.controller;



import com.pk.quiz_service_v3.model.questionWrapper;
import com.pk.quiz_service_v3.model.quizdto;
import com.pk.quiz_service_v3.model.userResponse;
import com.pk.quiz_service_v3.service.quizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class quizController {

    @Autowired
    private quizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody quizdto qd)
    {
        quizService.create(qd.getCategory(), qd.getNumq(),qd.getTitle());
        return new ResponseEntity<>("Success",HttpStatus.OK);
    }

    @GetMapping("getQuiz/{qid}")
    public ResponseEntity<List<questionWrapper>> playQuiz(@PathVariable int qid)
    {
        return new ResponseEntity<>(quizService.playQuizs(qid),HttpStatus.OK);
    }

    @PostMapping("submit/{qid}")
    public Integer result(@PathVariable int qid, @RequestBody List<userResponse> ur)
    {
        return quizService.getResult(qid,ur);
    }
}
