package kr.co.msa_popool;

import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.career.service.CareerService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.of;
import static kr.co.msa_popool.CareerFixture.MEMBER_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CareerServiceTest {

    @Mock
    CareerRepository careerRepository;
    @InjectMocks
    private CareerService careerService;

    @Test
    @DisplayName("아이디로 인사 내역을 조회하고 인사 내역을 불러온다.")
    public void career_조회() {

        when(careerRepository.findByMemberId(MEMBER_ID))
            .thenReturn(of(CareerFixture.createCareer()));

        assertThat(careerService.showCareer(MEMBER_ID))
            .isEqualTo(CareerFixture.createCareerInfo());

    }

}
