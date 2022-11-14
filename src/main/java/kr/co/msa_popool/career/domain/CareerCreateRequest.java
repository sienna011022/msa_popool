package kr.co.msa_popool.career.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CareerCreateRequest {

    @ApiModelProperty(example = "member 아이디")
    @NotBlank(message = "본인의 아이디를 입력하세요")
    private String memberId;

    @ApiModelProperty(example = "이름")
    @NotBlank(message = "이름를 입력해주세요.")
    private String name;

    @ApiModelProperty(example = "이메일")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @ApiModelProperty(example = "재직 기간")
    @NotBlank(message = "재직 기간을 입력해주세요")
    private String period;

    @ApiModelProperty(example = "간단한 자기 소개")
    @NotBlank(message = "간단한 자기 소개를 입력해주세요")
    private String selfDescription;

    @Builder
    public CareerCreateRequest(String memberId, String name, String email, String period, String selfDescription) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.period = period;
        this.selfDescription = selfDescription;
    }

    public Career toCareer(){
       return Career.newCareer(memberId,name,email,period,selfDescription);
    }
}
