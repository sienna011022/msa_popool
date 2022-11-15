package kr.co.msa_popool.career.web;


import io.swagger.annotations.ApiOperation;
import kr.co.msa_popool.career.web.dto.CareerCreateRequest;
import kr.co.msa_popool.career.service.CareerService;
import kr.co.msa_popool.career.web.dto.CareerResponse;
import kr.co.msa_popool.infra.ResponseFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/careers")
public class CareerController {

    private final CareerService careerService;

    @ApiOperation("개인 인사 내역 등록")
    @PostMapping(value = "/create")
    public ResponseFormat newCareer(@RequestBody CareerCreateRequest request) {
        careerService.createCareer(request);
        return ResponseFormat.ok();
    }


    @ApiOperation("개인 인사 내역 조회")
    @PostMapping(value = "/show")
    public ResponseFormat newCareer(@RequestParam String memberId) {
        CareerResponse careerInfo = careerService.showCareer(memberId);
        return ResponseFormat.ok(careerInfo);
    }
}
