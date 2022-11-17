package kr.co.msa_popool.score.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score,Long> {

    Score findByEvaluatorId(String evaluatorId);
}
