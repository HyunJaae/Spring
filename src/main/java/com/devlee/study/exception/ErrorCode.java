package com.devlee.study.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // 404 Not Found
    NOT_FOUND_ORDER_ID(HttpStatus.NOT_FOUND, "404_0", "주문하신 제품이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String errorCode;
    private final String errorMessage;

}
