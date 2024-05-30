package com.example.rankboard.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Score {
    private String userId;
    private Long score;
    private Long rank;
}
