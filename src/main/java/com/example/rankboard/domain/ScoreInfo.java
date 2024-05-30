package com.example.rankboard.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ScoreInfo {
    private String userId;
    private Long rank;
    private Double score;
}
