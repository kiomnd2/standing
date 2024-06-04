package com.example.rankboard.domain;

import java.util.List;

public interface RankBoardReader {
    Score read(String userId);
    List<Score> readTop10();
}
