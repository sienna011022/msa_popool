package kr.co.msa_popool;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.domain.CareerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

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
        String memberId = "sienna1022";

        when(careerRepository.findByMemberId(memberId))
            .thenReturn(Optional.of(Career.builder()
                .memberId(memberId)
                .name("sienna")
                .email("sienna011022@naver.com")
                .period("0years")
                .selfDescription("안녕하세요")
                .build()));

        Optional<Career> career = careerRepository.findByMemberId(memberId);

        assertThat(career.get().getMemberId()).isEqualTo(memberId);

    }


}
