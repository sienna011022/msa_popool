package kr.co.msa_popool.score.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score,Long> {

    List<Score> findByEvaluatorId(String evaluatorId);
}
