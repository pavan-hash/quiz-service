package com.pk.quiz_service_v3.Repository;



import com.pk.quiz_service_v3.model.quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quizRepo extends JpaRepository<quiz,Integer> {


}
