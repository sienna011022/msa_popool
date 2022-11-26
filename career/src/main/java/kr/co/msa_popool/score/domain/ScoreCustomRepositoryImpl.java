package kr.co.msa_popool.score.domain;

import com.querydsl.core.QueryResults;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;

import static kr.co.msa_popool.career.domain.QCareer.career;
import static kr.co.msa_popool.score.domain.QScore.score;

@RequiredArgsConstructor
public class ScoreCustomRepositoryImpl implements ScoreCustomRepository {

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Page<MyScoreResponse> findAllScores(String targetId, Pageable pageable) {
        QueryResults<MyScoreResponse> results = jpaQueryFactory.select(
                new QMyScoreResponse(
                    career.memberId.as("target_id"),
                    score.attendance,
                    score.sincerity,
                    score.positiveness,
                    score.technical,
                    score.cooperative))
            .from(score)
            .where(score.career.memberId.eq(targetId))
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetchResults();

        return PageableExecutionUtils.getPage(results.getResults(), pageable, results::getTotal);
    }

    @Override
    public MyScoreResponse findScore(String memberId, String evaluatorId) {
        return jpaQueryFactory.select(
                new QMyScoreResponse(
                    career.memberId.as("target_id"),
                    score.attendance,
                    score.sincerity,
                    score.positiveness,
                    score.technical,
                    score.cooperative))
            .from(score)
            .where(score.career.memberId.eq(memberId), score.evaluatorId.eq(evaluatorId))
            .fetchFirst();
    }


}


