package kr.co.msa_popool.career.web.dto;

import kr.co.msa_popool.career.domain.Career;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@NoArgsConstructor
public class CareerResponse {

    private String name;

    private String email;

    private String period;

    private String selfDescription;

    @Builder
    private CareerResponse(String name, String email, String period, String selfDescription) {
        this.name = name;
        this.email = email;
        this.period = period;
        this.selfDescription = selfDescription;

    }

    public static CareerResponse of(Career career) {
        return CareerResponse.builder()
            .name(career.getName())
            .email(career.getEmail())
            .period(career.getPeriod())
            .selfDescription(career.getSelfDescription())
            .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareerResponse that = (CareerResponse) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(period, that.period) && Objects.equals(selfDescription, that.selfDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, period, selfDescription);
    }
}

