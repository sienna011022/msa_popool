package kr.co.msa_popool;

import kr.co.msa_popool.career.domain.CareerCreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CareerCreateRequestTest {
    @Test
    @DisplayName("아이디를 입력하지 않으면 예외 발생")
    public void career_생성_예외1() {
        CareerCreateRequest errorRequest = new CareerCreateRequest(null, "김성윤", "sienna011022@naver.com", "0", "안녕하세요 백엔드 인턴을 준비중인 김성윤입니다");
        assertThatThrownBy(() -> errorRequest.toCareer()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름을 입력하지 않으면 예외 발생")
    public void career_생성_예외2() {
        CareerCreateRequest errorRequest = new CareerCreateRequest("sienna011022", null, "sienna011022@naver.com", "0", "안녕하세요 백엔드 인턴을 준비중인 김성윤입니다");
        assertThatThrownBy(() -> errorRequest.toCareer()).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("아이디를 입력하지 않으면 예외 발생")
    public void career_생성_예외3() {
        CareerCreateRequest errorRequest = new CareerCreateRequest("sienna011022", "김성윤", null, "0", "안녕하세요 백엔드 인턴을 준비중인 김성윤입니다");
        assertThatThrownBy(() -> errorRequest.toCareer()).isInstanceOf(IllegalArgumentException.class);
    }
}
