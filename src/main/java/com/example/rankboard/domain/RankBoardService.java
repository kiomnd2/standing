package com.example.rankboard.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class RankBoardService {
    private final RankBoardStore rankBoardStore;
    private final RankBoardReader rankBoardReader;

    @Transactional
    public ScoreInfo update(String userId, Integer point) {
        rankBoardStore.store(userId, point);
        Score read = rankBoardReader.read(userId);
        return read.toInfo();
    }
}
