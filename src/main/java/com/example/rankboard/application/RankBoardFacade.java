package com.example.rankboard.application;

import com.example.rankboard.domain.RankBoardService;
import com.example.rankboard.domain.ScoreInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RankBoardFacade {
    private final RankBoardService rankBoardService;

    public ScoreInfo updateScore(String userId, Integer point) {
        return rankBoardService.update(userId, point);
    }
}
