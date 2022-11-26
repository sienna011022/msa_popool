package kr.co.msa_popool.score.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, Long> , ScoreCustomRepository {

    Optional<List<Score>> findByEvaluatorId(String evaluatorId);
}
