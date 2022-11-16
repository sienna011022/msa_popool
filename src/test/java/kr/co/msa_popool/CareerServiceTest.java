package kr.co.msa_popool;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.career.service.CareerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.of;
import static kr.co.msa_popool.CareerFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
            .thenReturn(of(createCareer()));

        assertThat(careerService.showCareer(MEMBER_ID))
            .isEqualTo(createCareerInfo());

    }

    @Test
    @DisplayName("아이디로 인사 내역을 삭제한다 - 논리 삭제")
    public void career_삭제() {
        Career career = createCareer();

        when(careerRepository.findByMemberId(MEMBER_ID))
            .thenReturn(of(career));

        careerService.deleteCareer(MEMBER_ID);

        assertThat(careerRepository.findByMemberId(MEMBER_ID)
            .get()
            .isDeleted(Career.DELETED))
            .isEqualTo(true);
    }

    @Test
    @DisplayName("삭제된 인사내역은 조회하지 못한다")
    public void 삭제된_인사내역_조회() {
        Career deletedCareer = createCareer();
        deletedCareer.delete();

        when(careerRepository.findByMemberId(MEMBER_ID))
            .thenReturn(of(deletedCareer));

        assertThatThrownBy(() -> careerService.showCareer(MEMBER_ID))
            .isInstanceOf(IllegalStateException.class);

    }

}
