package kr.co.msa_popool.score.domain;

import kr.co.msa_popool.career.domain.BaseEntity;
import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.score.web.dto.ScoreCreateRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_score")
public class Score extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "career_id")
    private Career career;

    @Column(name = "evaluator_id", nullable = false, length = 100)
    private String evaluatorId;

    @Column(name = "attendance", nullable = false, length = 100)
    private int attendance;

    @Column(name = "sincerity", nullable = false, length = 100)
    private int sincerity;

    @Column(name = "positiveness", nullable = false, length = 100)
    private int positiveness;

    @Column(name = "technical", nullable = false, length = 100)
    private int technical;

    @Column(name = "cooperative", nullable = false, length = 100)
    private int cooperative;

    @Builder
    private Score(Long id, LocalDateTime createdAt, LocalDateTime updatedAt,Career career, String evaluatorId, int attendance, int sincerity, int positiveness, int technical, int cooperative) {
        super(id,createdAt,updatedAt);
        this.career = career;
        this.evaluatorId = evaluatorId;
        this.attendance = attendance;
        this.sincerity = sincerity;
        this.positiveness = positiveness;
        this.technical = technical;
        this.cooperative = cooperative;
    }

}
