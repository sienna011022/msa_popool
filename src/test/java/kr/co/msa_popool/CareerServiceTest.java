package kr.co.msa_popool;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.web.dto.CareerCreateRequest;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.career.service.CareerService;
import kr.co.msa_popool.career.web.dto.CareerInfo;
import kr.co.msa_popool.infra.ResponseFormat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static kr.co.msa_popool.infra.ResponseCode.SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CareerServiceTest {

    @Mock
    CareerRepository careerRepository;
    @InjectMocks
    private CareerService careerService;

    public static final String TEST_MEMBER_ID = "sienna1022";
    public static final String TEST_NAME = "김성윤";
    public static final String TEST_EMAIL = "sienna011022@naver.com";
    public static final String TEST_PERIOD = "0years";
    public static final String TEST_SELF_DESCRIPTION = "안녕하세요 백엔드 인턴을 준비중인 김성윤입니다";

    private CareerCreateRequest careerRequest;
    private CareerInfo careerResponse;
    private Career savedCareer;

    @BeforeEach
    public void setUp() {

      careerRequest = CareerCreateRequest.builder()
            .memberId(TEST_MEMBER_ID)
            .name(TEST_NAME)
            .email(TEST_EMAIL)
            .period(TEST_PERIOD)
            .selfDescription(TEST_SELF_DESCRIPTION)
            .build();

       careerResponse = CareerInfo.builder()
            .name(TEST_NAME)
            .email(TEST_EMAIL)
            .period(TEST_PERIOD)
            .selfDescription(TEST_SELF_DESCRIPTION)
            .build();


       savedCareer = Career.builder()
           .memberId(TEST_MEMBER_ID)
           .name(TEST_NAME)
           .email(TEST_EMAIL)
           .period(TEST_PERIOD)
           .selfDescription(TEST_SELF_DESCRIPTION)
           .build();
    }

    @Test
    @DisplayName("인사 내역을 정상적으로 생성한다.")
    public void career_생성() {
        ResponseFormat response = careerService.createCareer(careerRequest);
        assertThat(response.getCode()).isEqualTo(SUCCESS.getCode());
    }

    @Test
    @DisplayName("인사 내역을 조회한다")
    public void career_조회() {

        when(careerRepository.findByMemberId(TEST_MEMBER_ID)).thenReturn(
            Optional.of(savedCareer));

        assertThat(careerService.showCareer(TEST_MEMBER_ID).getData())
            .isEqualTo(careerResponse);
    }

}
