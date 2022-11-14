package kr.co.msa_popool;

import kr.co.msa_popool.career.web.dto.CareerCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CareerCreateRequestTest {
    @Test
    @DisplayName("아이디를 입력하지 않으면 예외 발생")
    public void career_생성_예외1() {
        CareerCreateRequest errorRequest = CareerCreateRequest.builder()
            .memberId(null)
            .name("김성윤")
            .email("sienna011022@naver.com")
            .period("0")
            .selfDescription("안녕하세요 백엔드 인턴을 준비중인 김성윤입니다")
            .build();

        assertThatThrownBy(() -> errorRequest.toCareer()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 입력하지 않으면 예외 발생")
    public void career_생성_예외2() {
        CareerCreateRequest errorRequest = CareerCreateRequest.builder()
            .memberId("sienna1022")
            .name(null)
            .email("sienna011022@naver.com")
            .period("0")
            .selfDescription("안녕하세요 백엔드 인턴을 준비중인 김성윤입니다")
            .build();

        assertThatThrownBy(() -> errorRequest.toCareer()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이메일을 입력하지 않으면 예외 발생")
    public void career_생성_예외3() {

        CareerCreateRequest errorRequest = CareerCreateRequest.builder()
            .memberId("sienna1022")
            .name("김성윤")
            .email(null)
            .period("0")
            .selfDescription("안녕하세요 백엔드 인턴을 준비중인 김성윤입니다")
            .build();

        assertThatThrownBy(() -> errorRequest.toCareer()).isInstanceOf(IllegalArgumentException.class);
    }
}
