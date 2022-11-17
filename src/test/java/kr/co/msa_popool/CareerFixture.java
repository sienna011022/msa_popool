package kr.co.msa_popool;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.web.dto.CareerResponse;
import kr.co.msa_popool.career.web.dto.CareerUpdateRequest;

public class CareerFixture {

    public final static String MEMBER_ID = "sienna1022";
    public final static String NAME = "김성윤";
    public final static String EMAIL = "sienna011022@naver.com";
    public final static String PERIOD = "0years";
    public final static String SELF_DESCRIPTION = "안녕하세요 백엔드 인턴을 준비중인 김성윤입니다";

    public final static String UPDATE_SELF_DESCRIPTION = "안녕하세요 백엔드 주니어 개발자 김성윤입니다";

    public static Career createCareer() {
        return Career.builder()
            .memberId(MEMBER_ID)
            .name(NAME)
            .email(EMAIL)
            .period(PERIOD)
            .selfDescription(SELF_DESCRIPTION)
            .build();
    }

    public static CareerResponse createCareerInfo() {
        return CareerResponse.builder()
            .name(NAME)
            .email(EMAIL)
            .period(PERIOD)
            .selfDescription(SELF_DESCRIPTION)
            .build();
    }

    public static CareerResponse updateCareer() {
        return CareerResponse.builder()
            .name(NAME)
            .email(EMAIL)
            .period(PERIOD)
            .selfDescription(UPDATE_SELF_DESCRIPTION)
            .build();
    }

    public static CareerUpdateRequest createUpdateRequest() {
        return CareerUpdateRequest.builder()
            .name(NAME)
            .email(EMAIL)
            .selfDescription(UPDATE_SELF_DESCRIPTION)
            .period(PERIOD)
            .build();
    }
}
