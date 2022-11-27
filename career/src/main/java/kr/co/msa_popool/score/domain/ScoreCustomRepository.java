package kr.co.msa_popool.score.domain;

import kr.co.msa_popool.score.web.dto.ScoreResponse;


import java.util.List;

public interface ScoreCustomRepository {
    List<ScoreResponse> findAllScores(String targetId);
}
