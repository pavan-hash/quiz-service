package com.pk.quiz_service_v3.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qid;
    private String title;
    @ElementCollection
    private List<Integer> questionIds;

}
