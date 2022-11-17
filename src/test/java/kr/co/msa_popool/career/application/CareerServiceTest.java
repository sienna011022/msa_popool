package kr.co.msa_popool.career.application;

import kr.co.msa_popool.career.web.CareerFixture;
import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.career.service.CareerService;
import kr.co.msa_popool.career.web.dto.CareerUpdateRequest;
import kr.co.msa_popool.exception.DeletedCareerException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.of;
import static kr.co.msa_popool.career.web.CareerFixture.*;
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

        when(careerRepository.findByMemberId(MEMBER_ID))
            .thenReturn(of(createCareer()));

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
            .isInstanceOf(DeletedCareerException.class);
    }

    @Test
    @DisplayName("인사 내역을 수정할 수 있다")
    public void 인사내역_수정() {

        when(careerRepository.findByMemberId(MEMBER_ID))
            .thenReturn(of(createCareer()));

        CareerUpdateRequest request = CareerFixture.createUpdateRequest();
        careerService.updateCareer(MEMBER_ID, request);

        assertThat(careerService.showCareer(MEMBER_ID)).isEqualTo(updateCareer());
    }
}
