package kr.co.msa_popool;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.domain.CareerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static kr.co.msa_popool.CareerServiceTest.*;
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

        when(careerRepository.findByMemberId(TEST_MEMBER_ID))
            .thenReturn(Optional.of(Career.builder()
                .memberId(TEST_MEMBER_ID)
                .name(TEST_NAME)
                .email(TEST_EMAIL)
                .period(TEST_PERIOD)
                .selfDescription(TEST_SELF_DESCRIPTION)
                .build()));

        Optional<Career> career = careerRepository.findByMemberId(TEST_MEMBER_ID);

        assertThat(career.get().getMemberId()).isEqualTo(TEST_MEMBER_ID);

    }


}
