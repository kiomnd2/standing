package com.example.rankboard.domain;

import com.example.rankboard.config.RedisTestConfig;
import org.assertj.core.api.Assertions;
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
        ScoreInfo userId2 = rankBoardService.update("userId2", 1);
        // userId 2점 랭크 0 user
        ScoreInfo _userId = rankBoardService.update("userId", 1);

        Assertions.assertThat(_userId.getUserId()).isEqualTo(userId.getUserId());
        Assertions.assertThat(_userId.getRank()).isEqualTo(0);
        Assertions.assertThat(_userId.getScore()).isEqualTo(2);

    }
}
