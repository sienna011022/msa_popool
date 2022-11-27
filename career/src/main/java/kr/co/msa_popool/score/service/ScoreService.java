package kr.co.msa_popool.score.service;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.exception.NotFoundCareerException;
import kr.co.msa_popool.score.NotFoundScoreException;
import kr.co.msa_popool.score.web.dto.ScoreResponse;
import kr.co.msa_popool.score.domain.Score;
import kr.co.msa_popool.score.domain.ScoreRepository;
import kr.co.msa_popool.score.web.dto.ScoreResponses;
import kr.co.msa_popool.score.web.dto.ScoreCreateRequest;
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
    public void newScore(ScoreCreateRequest request) {

        Career career = careerRepository.findByMemberId(request.getMemberId())
            .orElseThrow(NotFoundCareerException::new);

        Score requestScore = request.toScore(career);
        scoreRepository.save(requestScore);
    }

    @Transactional(readOnly = true)
    public ScoreResponses showScoreAllByEvaluator(String evaluatorId) {
        List<Score> score = findScore(evaluatorId);

        return ScoreResponses.of(score.stream()
            .map(ScoreResponse::of)
            .collect(Collectors.toList()));
    }

    @Transactional(readOnly = true)
    public ScoreResponses showMyAllScore(String targetId) {
        List<ScoreResponse> scoreResponses = scoreRepository.findAllScores(targetId);
        return ScoreResponses.of(scoreResponses);
    }

    private List<Score> findScore(String evaluatorId) {
        return scoreRepository.findByEvaluatorId(evaluatorId).orElseThrow(NotFoundScoreException::new);
    }

}
