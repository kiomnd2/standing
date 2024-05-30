package com.example.rankboard.interfaces;

import com.example.rankboard.domain.ScoreInfo;
import lombok.Builder;
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
    @Builder
    public static class ResponsePoint {
        private String userId;
        private Long rank;
        private Double score;

        public static ResponsePoint byInfo(ScoreInfo info) {
            return ResponsePoint.builder()
                    .userId(info.getUserId())
                    .rank(info.getRank())
                    .score(info.getScore())
                    .build();
        }
    }
}
