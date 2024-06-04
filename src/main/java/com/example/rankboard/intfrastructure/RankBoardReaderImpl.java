package com.example.rankboard.intfrastructure;

import com.example.rankboard.domain.RankBoardReader;
import com.example.rankboard.domain.Score;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        Long rank = zSet.reverseRank(RANK_BOARD_KEY, userId) + 1L;
        return Score.builder()
                .userId(userId)
                .score(score)
                .rank(rank)
                .build();
    }

    @Override
    public List<Score> readTop10() {
        Set<ZSetOperations.TypedTuple<String>> typedTuples =
                zSet.reverseRangeByScoreWithScores(RANK_BOARD_KEY, 0, 10);
        long rank=0;
        List<Score> result = new ArrayList<>();
        for (ZSetOperations.TypedTuple<String> typedTuple : typedTuples) {
            rank++;
            String userId = typedTuple.getValue();
            Double score = typedTuple.getScore();

            result.add(Score.builder()
                            .userId(userId)
                            .score(score)
                            .rank(rank)
                    .build());
        }
        return result;
    }
}
