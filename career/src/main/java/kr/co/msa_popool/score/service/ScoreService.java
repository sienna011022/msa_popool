package kr.co.msa_popool.score.service;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.exception.NotFoundCareerException;
import kr.co.msa_popool.score.domain.Score;
import kr.co.msa_popool.score.domain.ScoreRepository;
import kr.co.msa_popool.score.web.dto.ScoreCreateRequest;
import kr.co.msa_popool.score.web.dto.ScoreResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Getter
@RequiredArgsConstructor
@Service
public class ScoreService {
    private final CareerRepository careerRepository;
    private final ScoreRepository scoreRepository;

    @Transactional
    public void newScore(String memberId, ScoreCreateRequest request) {

        Career career = careerRepository.findByMemberId(memberId)
            .orElseThrow(NotFoundCareerException::new);

        Score requestScore = request.toScore(career);

        scoreRepository.save(requestScore);
    }

    @Transactional
    public List<ScoreResponse> showScoreAllByEvaluator(String evaluatorId) {
        List<Score> score = scoreRepository.findByEvaluatorId(evaluatorId);
        return score.stream()
            .map(score1 -> ScoreResponse.of(score1))
            .collect(Collectors.toList());
    }
}
