package kr.co.msa_popool.infra;

import kr.co.msa_popool.exception.BadRequestException;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ResponseCode {

    SUCCESS(1), FAIL(2);

    int code;

    public static ResponseCode of(int num){
        return Arrays.stream(ResponseCode.values())
            .filter(responseCode -> responseCode.getCode() == num)
            .findFirst().orElseThrow(() -> new BadRequestException("응답 코드를 찾을 수 없습니다."));
    }
}

