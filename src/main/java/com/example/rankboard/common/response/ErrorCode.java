package com.example.rankboard.common.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    COMMON_SYSTEM_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요.");

    private final String message;
    public String getMessage(Object ...args) {
        return String.format(message, args);
    }
}