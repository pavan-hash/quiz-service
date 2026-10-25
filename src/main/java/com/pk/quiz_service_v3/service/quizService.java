package com.pk.quiz_service_v3.service;



import com.pk.quiz_service_v3.Feign.QuizFeign;
import com.pk.quiz_service_v3.Repository.quizRepo;
import com.pk.quiz_service_v3.model.questionWrapper;
import com.pk.quiz_service_v3.model.quiz;
import com.pk.quiz_service_v3.model.userResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class quizService {
    @Autowired
    private quizRepo qr;

    @Autowired
    private QuizFeign qf;

    public void create(String category, int numq, String title) {
        List<Integer> questions = qf.generateQuestions(category, numq).getBody();
        quiz quiz = new quiz();
        quiz.setTitle(title);
        quiz.setQuestionIds(questions);
        qr.save(quiz);
    }

    public List<questionWrapper> playQuizs(int qid) {
        Optional<quiz> quiz = qr.findById(qid);
        List<questionWrapper> questionWrappers = qf.getQuestionsByIds(quiz.get().getQuestionIds()).getBody();

    return questionWrappers;
    }

    public Integer getResult(int qid, List<userResponse> ur) {
        int result = qf.getScore(ur).getBody();

        return result;
    }
}