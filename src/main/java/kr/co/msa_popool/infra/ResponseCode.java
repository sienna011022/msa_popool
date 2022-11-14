package kr.co.msa_popool.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(1), FAIL(2);

    private int code;
}

