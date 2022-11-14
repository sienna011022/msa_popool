package kr.co.msa_popool.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    NOT_FOUND_CAREER("N201", "아이디에 해당하는 인사 내역이 없습니다");

    private final String code;
    private final String message;
}
