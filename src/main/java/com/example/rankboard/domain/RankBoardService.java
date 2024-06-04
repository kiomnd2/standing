package com.example.rankboard.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    public ScoreInfo getScore(String userId) {
        return rankBoardReader.read(userId).toInfo();
    }

    public List<ScoreInfo> getTop10Player() {
        return rankBoardReader.readTop10().stream().map(Score::toInfo).collect(Collectors.toList());
    }
}
