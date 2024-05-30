package com.example.rankboard.domain;

public interface RankBoardStore {
    void store(String userId, Integer score);
}
