package com.example.rankboard.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Score {
    private String userId;
    private Double score;
    private Long rank;

    public ScoreInfo toInfo() {
        return ScoreInfo.builder()
                .userId(userId)
                .score(score)
                .rank(rank)
                .build();
    }
}
