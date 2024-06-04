package com.example.rankboard.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class ScoreInfo {
    private String userId;
    private Long rank;
    private Double score;
}
