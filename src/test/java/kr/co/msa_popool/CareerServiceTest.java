package kr.co.msa_popool;

import kr.co.msa_popool.career.domain.CareerCreateRequest;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.career.service.CareerService;
import kr.co.msa_popool.infra.ResponseFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static kr.co.msa_popool.infra.ResponseCode.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
public class CareerServiceTest {

    @Mock
    CareerRepository careerRepository;
    @InjectMocks
    private CareerService careerService;

    private CareerCreateRequest careerRequest;


    @BeforeEach
    public void setUp() {
        careerRequest = new CareerCreateRequest("id", "sienna", "sienna011022@naver.com", "0years", "안녕하세요 백엔드 인턴을 준비중인 김성윤입니다");
    }

    @Test
    @DisplayName("인사 내역을 정상적으로 생성한다.")
    public void career_생성() {
        ResponseFormat response = careerService.createCareer(careerRequest);
        assertThat(response.getCode()).isEqualTo(SUCCESS.getCode());
    }

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
