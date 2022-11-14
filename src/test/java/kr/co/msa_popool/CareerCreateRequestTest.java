package kr.co.msa_popool;

import kr.co.msa_popool.career.web.dto.CareerCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static kr.co.msa_popool.CareerServiceTest.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CareerCreateRequestTest {
    @Test
    @DisplayName("아이디를 입력하지 않으면 예외 발생")
    public void career_생성_예외1() {

        CareerCreateRequest errorRequest = CareerCreateRequest.builder()
            .memberId(null)
            .name(TEST_NAME)
            .email(TEST_EMAIL)
            .period(TEST_PERIOD)
            .selfDescription(TEST_SELF_DESCRIPTION)
            .build();

        assertThatThrownBy(() -> errorRequest.toCareer()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 입력하지 않으면 예외 발생")
    public void career_생성_예외2() {
        CareerCreateRequest errorRequest = CareerCreateRequest.builder()
            .memberId(TEST_MEMBER_ID)
            .name(null)
            .email(TEST_EMAIL)
            .period(TEST_PERIOD)
            .selfDescription(TEST_SELF_DESCRIPTION)
            .build();

        assertThatThrownBy(() -> errorRequest.toCareer()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이메일을 입력하지 않으면 예외 발생")
    public void career_생성_예외3() {

        CareerCreateRequest errorRequest = CareerCreateRequest.builder()
            .memberId(TEST_MEMBER_ID)
            .name(TEST_NAME)
            .email(null)
            .period(TEST_PERIOD)
            .selfDescription(TEST_SELF_DESCRIPTION)
            .build();

        assertThatThrownBy(() -> errorRequest.toCareer()).isInstanceOf(IllegalArgumentException.class);
    }
}
