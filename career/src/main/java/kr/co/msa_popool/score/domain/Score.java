package kr.co.msa_popool.score.domain;

import kr.co.msa_popool.career.domain.BaseEntity;
import kr.co.msa_popool.career.domain.Career;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

import static org.springframework.util.Assert.hasText;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_score")
public class Score extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Career career;

    @Column(nullable = false)
    private String evaluatorId;

    private int attendance;

    private int sincerity;

    private int positiveness;

    private int technical;

    private int cooperative;

    @Builder
    private Score(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, Career career, String evaluatorId, int attendance, int sincerity, int positiveness, int technical, int cooperative) {
        super(id, createdAt, updatedAt);
        hasText(evaluatorId, "평가자 아이디를 입력하세요");

        this.career = career;
        this.evaluatorId = evaluatorId;
        this.attendance = attendance;
        this.sincerity = sincerity;
        this.positiveness = positiveness;
        this.technical = technical;
        this.cooperative = cooperative;
    }

}
