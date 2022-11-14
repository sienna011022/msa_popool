package kr.co.msa_popool.career.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "tbl_career")
public class Career extends BaseEntity {

    @Column(name = "memberId", nullable = false, length = 100)
    private String memberId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "period", nullable = false, length = 100)
    private String period;

    @Lob
    private String selfDescription;

    @Column(name = "del_yn", nullable = false)
    private String deleted;

    @Builder
    private Career(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String memberId, String name, String email, String period, String selfDescription) {
        super(id, createdAt, updatedAt);
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.period = period;
        this.selfDescription = selfDescription;
        this.deleted = "N";
    }

    public static Career newCareer(String memberId, String name, String email, String period, String selfDescription) {
        return Career.builder()
            .memberId(memberId)
            .name(name)
            .email(email)
            .period(period)
            .selfDescription(selfDescription)
            .build();
    }
}
