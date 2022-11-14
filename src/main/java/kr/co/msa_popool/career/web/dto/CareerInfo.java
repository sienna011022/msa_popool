package kr.co.msa_popool.career.web.dto;

import lombok.Builder;

import java.util.Objects;

public class CareerInfo {

    private String name;

    private String email;

    private String period;

    private String selfDescription;

    @Builder
    private CareerInfo(String name, String email, String period, String selfDescription) {
        this.name = name;
        this.email = email;
        this.period = period;
        this.selfDescription = selfDescription;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CareerInfo that = (CareerInfo) o;
        return Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(period, that.period) && Objects.equals(selfDescription, that.selfDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, period, selfDescription);
    }
}

