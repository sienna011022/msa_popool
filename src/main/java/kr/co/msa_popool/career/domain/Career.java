package kr.co.msa_popool.career.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static org.springframework.util.Assert.hasText;

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

    @Column(name = "period", length = 100)
    private String period;

    @Lob
    private String selfDescription;

    @Column(name = "del_yn", nullable = false)
    private String deleted;

    @Builder
    private Career(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String memberId, String name, String email, String period, String selfDescription) {
        super(id, createdAt, updatedAt);

        hasText(memberId, "아이디를 입력하세요");
        hasText(name, "이름을 입력하세요");
        hasText(email, "이메일을 입력하세요");

        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.period = period;
        this.selfDescription = selfDescription;
        this.deleted = "N";
    }



}
