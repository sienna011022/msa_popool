package kr.co.msa_popool.score.web;

import kr.co.msa_popool.career.web.CareerFixture;
import kr.co.msa_popool.score.domain.Score;
import kr.co.msa_popool.score.web.dto.ScoreCreateRequest;
import kr.co.msa_popool.score.web.dto.ScoreResponse;

import static kr.co.msa_popool.career.web.CareerFixture.MEMBER_ID;

public class ScoreFixture {
    public static final String EVALUATOR_ID = "evaluator1022";
    private static final int DEFAULT_TEST_SCORE = 5;

    public static Score createScore() {
        return Score.builder()
            .career(CareerFixture.createCareer())
            .evaluatorId(EVALUATOR_ID)
            .attendance(DEFAULT_TEST_SCORE)
            .cooperative(DEFAULT_TEST_SCORE)
            .positiveness(DEFAULT_TEST_SCORE)
            .sincerity(DEFAULT_TEST_SCORE)
            .technical(DEFAULT_TEST_SCORE)
            .build();
    }

    public static ScoreCreateRequest createScoreRequest() {
        return ScoreCreateRequest.builder()
            .memberId(MEMBER_ID)
            .evaluatorId(EVALUATOR_ID)
            .attendance(DEFAULT_TEST_SCORE)
            .cooperative(DEFAULT_TEST_SCORE)
            .positiveness(DEFAULT_TEST_SCORE)
            .sincerity(DEFAULT_TEST_SCORE)
            .technical(DEFAULT_TEST_SCORE)
            .build();
    }


    public static ScoreResponse createScoreResponse() {
        return ScoreResponse.builder()
            .targetId(MEMBER_ID)
            .attendance(DEFAULT_TEST_SCORE)
            .cooperative(DEFAULT_TEST_SCORE)
            .positiveness(DEFAULT_TEST_SCORE)
            .sincerity(DEFAULT_TEST_SCORE)
            .technical(DEFAULT_TEST_SCORE)
            .build();
    }

}
