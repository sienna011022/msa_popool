package kr.co.msa_popool.score.domain;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.msa_popool.score.web.dto.ScoreResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static kr.co.msa_popool.score.domain.QScore.score;

@RequiredArgsConstructor
public class ScoreCustomRepositoryImpl implements ScoreCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<ScoreResponse> findAllScores(String memberId) {
        return jpaQueryFactory.select(
                new QMyScoreResponse(
                    score.career.memberId,
                    score.attendance,
                    score.sincerity,
                    score.positiveness,
                    score.technical,
                    score.cooperative))
            .from(score)
            .where(score.career.memberId.eq(memberId))
            .fetch();
    }
}


