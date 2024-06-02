package com.example.rankboard.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

import java.io.IOException;

@Profile("test")
@DisplayName("Embedded Redis 설정")
@TestConfiguration
public class RedisTestConfig {

    private RedisServer redisServer;

    public RedisTestConfig() throws IOException {
        this.redisServer = new RedisServer(6379);
    }

    @PostConstruct
    public void startRedis() {
        this.redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        this.redisServer.stop();
    }
}
