package kr.co.msa_popool.score.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScoreCustomRepository {
    Page<MyScoreResponse> findAllScores(String targetId, Pageable pageable);

    MyScoreResponse findScore(String memberId, String evaluatorId);

}
