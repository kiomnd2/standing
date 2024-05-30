package com.example.rankboard.intfrastructure;

import com.example.rankboard.domain.RankBoardStore;
import com.example.rankboard.domain.Score;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.ReactiveZSetCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Component
public class RankBoardStoreImpl implements RankBoardStore {
    private final RedisTemplate<String, String> redisTemplate;
    private static final String RANK_BOARD_KEY = "KEY";
    private ZSetOperations<String, String> zSet;

    @PostConstruct
    public void init() {
        zSet = redisTemplate.opsForZSet();
    }

    @Override
    public void store(String userId, Integer score) {

        zSet.add(RANK_BOARD_KEY, userId, score);
    }
}
