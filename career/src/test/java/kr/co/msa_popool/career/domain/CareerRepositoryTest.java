package kr.co.msa_popool.career.domain;

import kr.co.msa_popool.career.web.CareerFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static kr.co.msa_popool.career.web.CareerFixture.MEMBER_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class CareerRepositoryTest {

    @Mock
    CareerRepository careerRepository;

    @AfterEach
    public void cleanup() {
        careerRepository.deleteAll();
    }

    @Test
    public void 인사내역불러오기() {

        when(careerRepository.findByMemberId(MEMBER_ID))
            .thenReturn(ofNullable(CareerFixture.createCareer()));

        Optional<Career> career = careerRepository.findByMemberId(MEMBER_ID);

        assertThat(career.get().getMemberId()).isEqualTo(MEMBER_ID);

    }


}
