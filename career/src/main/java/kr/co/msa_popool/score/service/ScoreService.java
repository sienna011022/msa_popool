package kr.co.msa_popool.score.service;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.exception.NotFoundCareerException;
import kr.co.msa_popool.score.NotFoundScoreException;
import kr.co.msa_popool.score.domain.MyScoreResponse;
import kr.co.msa_popool.score.domain.Score;
import kr.co.msa_popool.score.domain.ScoreRepository;
import kr.co.msa_popool.score.web.dto.ScoreCreateRequest;
import kr.co.msa_popool.score.web.dto.ScoreResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional
    public List<ScoreResponse> showScoreAllByEvaluator(String evaluatorId) {
        List<Score> score = findScore(evaluatorId);
        return score.stream()
            .map(ScoreResponse::of)
            .collect(Collectors.toList());
    }

    @Transactional
    public Page<MyScoreResponse> showMyAllScore(String targetId, Pageable pageable) {
        return scoreRepository.findAllScores(targetId, pageable);
    }

    @Transactional
    public MyScoreResponse showScore(String memberId, String evaluatorId) {
        return scoreRepository.findScore(memberId, evaluatorId);
    }

    private List<Score> findScore(String evaluatorId) {
        return scoreRepository.findByEvaluatorId(evaluatorId).orElseThrow(NotFoundScoreException::new);
    }

}
