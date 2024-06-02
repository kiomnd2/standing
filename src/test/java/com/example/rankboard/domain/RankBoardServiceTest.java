package com.example.rankboard.domain;

import com.example.rankboard.config.RedisTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@Import(RedisTestConfig.class)
@SpringBootTest
public class RankBoardServiceTest {

    @Autowired
    RankBoardService rankBoardService;

    @Test
    public void update_test() {
        ScoreInfo userId = rankBoardService.update("userId", 1);
        ScoreInfo userId2 = rankBoardService.update("userId2", 4);
        ScoreInfo userId33 = rankBoardService.update("userId", 1);
        System.out.println("userId2 = " + userId2.getUserId());
        System.out.println("userId2.getRank() = " + userId2.getRank());
        System.out.println(userId2.getScore());

        System.out.println("userId33 = " + userId33.getUserId());
        System.out.println("userId33.getRank() = " + userId33.getRank());
        System.out.println(userId33.getScore());
    }
}
