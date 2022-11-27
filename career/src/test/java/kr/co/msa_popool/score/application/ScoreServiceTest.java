package kr.co.msa_popool.score.application;

import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.score.domain.ScoreRepository;
import kr.co.msa_popool.score.service.ScoreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;

import static java.util.Arrays.asList;
import static java.util.Optional.of;
import static kr.co.msa_popool.career.web.CareerFixture.*;
import static kr.co.msa_popool.score.web.ScoreFixture.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ScoreServiceTest {
    @Mock
    CareerRepository careerRepository;

    @Mock
    ScoreRepository scoreRepository;

    @InjectMocks
    ScoreService scoreService;

    @Test
    @DisplayName("인사 내역을 등록하고, 평가자 아이디로 자신이 평가한 평가를 모두 조회할 수 있다")
    public void 평가_등록_및_조회() {
        when(careerRepository.findByMemberId(MEMBER_ID))
            .thenReturn(of(createCareer()));

        when(scoreRepository.findByEvaluatorId(EVALUATOR_ID))
            .thenReturn(of(asList(createScore())));

        scoreService.newScore(createScoreRequest());
        assertThat(scoreService.showScoreAllByEvaluator(EVALUATOR_ID)).isEqualTo(createScoreResponses());
    }

}
