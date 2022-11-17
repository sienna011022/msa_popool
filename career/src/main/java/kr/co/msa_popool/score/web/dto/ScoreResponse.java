package kr.co.msa_popool.score.web.dto;

import kr.co.msa_popool.score.domain.Score;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
public class ScoreResponse {

    private int attendance;

    private int sincerity;

    private int positiveness;

    private int technical;


    private int cooperative;

    public static ScoreResponse of(Score score) {
        return ScoreResponse.builder()
            .attendance(score.getAttendance())
            .cooperative(score.getCooperative())
            .positiveness(score.getPositiveness())
            .technical(score.getTechnical())
            .sincerity(score.getSincerity())
            .build();
    }

    @Builder
    public ScoreResponse(int attendance, int sincerity, int positiveness, int technical, int cooperative) {
        this.attendance = attendance;
        this.sincerity = sincerity;
        this.positiveness = positiveness;
        this.technical = technical;
        this.cooperative = cooperative;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreResponse that = (ScoreResponse) o;
        return attendance == that.attendance && sincerity == that.sincerity && positiveness == that.positiveness && technical == that.technical && cooperative == that.cooperative;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attendance, sincerity, positiveness, technical, cooperative);
    }
}
