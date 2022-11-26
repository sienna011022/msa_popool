package kr.co.msa_popool.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    NOT_FOUND_CAREER("N201", "아이디에 해당하는 인사 내역이 없습니다"),
    DELETED_CAREER("N202", "삭제된 인사 내역입니다"),

    NOT_FOUND_SCORE("N301","평가자 아이디에 해당하는 평가 내역이 없습니다" );

    private final String code;
    private final String message;
}
