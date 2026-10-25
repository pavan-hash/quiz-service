package com.pk.quiz_service_v3.Feign;


import com.pk.quiz_service_v3.model.questionWrapper;
import com.pk.quiz_service_v3.model.userResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@FeignClient("QUESTION-SERVICE-V3")
public interface QuizFeign {
    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestions(@RequestParam String category, @RequestParam Integer numq);
    @GetMapping("question/get")
    public ResponseEntity<List<questionWrapper>> getQuestionsByIds(@RequestBody List<Integer> qids);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<userResponse> ur);
}
