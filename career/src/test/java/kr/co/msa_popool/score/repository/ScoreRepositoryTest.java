package kr.co.msa_popool.score.repository;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.career.web.CareerFixture;
import kr.co.msa_popool.common.QueryDslConfiguration;
import kr.co.msa_popool.score.domain.Score;
import kr.co.msa_popool.score.domain.ScoreRepository;
import kr.co.msa_popool.score.web.ScoreFixture;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static kr.co.msa_popool.career.web.CareerFixture.MEMBER_ID;
import static kr.co.msa_popool.score.web.ScoreFixture.EVALUATOR_ID;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(QueryDslConfiguration.class)
public class ScoreRepositoryTest {

    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    CareerRepository careerRepository;


    @Test
    @Transactional
    @DisplayName("평가를 저장하고 조회한다")
    void createScore() {
        Score score1 = ScoreFixture.createScore();
        Score score2 = ScoreFixture.createScore();

        scoreRepository.save(score1);
        scoreRepository.save(score2);

        Optional<List<Score>> scores = scoreRepository.findByEvaluatorId(EVALUATOR_ID);

        assertThat(scores.get().size()).isEqualTo(2);

    }

    @Test
    @Transactional
    @DisplayName("QueryDsl : memberId의 모든 평가를 조회한다")
    void findByMemberId() {
        Score score1 = ScoreFixture.createScore();
        Score score2 = ScoreFixture.createScore();

        scoreRepository.save(score1);
        scoreRepository.save(score2);

        assertThat(scoreRepository.findAllScores(MEMBER_ID).size())
            .isEqualTo(2);
    }

}
