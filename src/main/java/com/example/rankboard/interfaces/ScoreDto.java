package com.example.rankboard.interfaces;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ScoreDto {

    @Getter
    @Setter
    @ToString
    public static class RequestPoint {
        private String userId;
        private Integer point;
    }

    @Getter
    @Setter
    @ToString
    public static class ResponsePoint {
        private String userId;
        private Integer rank;
        private Integer score;
    }
}
