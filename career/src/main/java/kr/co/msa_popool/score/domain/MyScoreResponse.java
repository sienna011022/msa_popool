package kr.co.msa_popool.score.domain;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class MyScoreResponse {
    private String targetId;

    private int attendance;

    private int sincerity;

    private int positiveness;

    private int technical;

    private int cooperative;

    @QueryProjection
    public MyScoreResponse(String targetId, int attendance, int sincerity, int positiveness, int technical, int cooperative) {
        this.targetId = targetId;
        this.attendance = attendance;
        this.sincerity = sincerity;
        this.positiveness = positiveness;
        this.technical = technical;
        this.cooperative = cooperative;
    }
}
