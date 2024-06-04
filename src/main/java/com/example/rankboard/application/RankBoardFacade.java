package com.example.rankboard.application;

import com.example.rankboard.domain.RankBoardService;
import com.example.rankboard.domain.ScoreInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RankBoardFacade {
    private final RankBoardService rankBoardService;

    public ScoreInfo updateScore(String userId, Integer point) {
        return rankBoardService.update(userId, point);
    }

    public ScoreInfo getScore(String userId) {
        return rankBoardService.getScore(userId);
    }

    public List<ScoreInfo> getTop10Player() {
        return rankBoardService.getTop10Player();
    }
}
