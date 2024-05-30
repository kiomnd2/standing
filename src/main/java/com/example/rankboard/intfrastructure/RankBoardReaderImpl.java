package com.example.rankboard.intfrastructure;

import com.example.rankboard.domain.RankBoardReader;
import com.example.rankboard.domain.Score;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RankBoardReaderImpl implements RankBoardReader {
    private final RedisTemplate<String, String> redisTemplate;
    private static final String RANK_BOARD_KEY = "KEY";
    private ZSetOperations<String, String> zSet;

    @PostConstruct
    public void init() {
        zSet = redisTemplate.opsForZSet();
    }

    @Override
    public Score read(String userId) {
        Double score = zSet.score(RANK_BOARD_KEY, userId);
        Long rank = zSet.rank(RANK_BOARD_KEY, userId);
        return Score.builder()
                .userId(userId)
                .score(score)
                .rank(rank)
                .build();
    }
}
