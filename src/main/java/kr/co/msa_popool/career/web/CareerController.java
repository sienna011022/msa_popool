package kr.co.msa_popool.career.web;


import io.swagger.annotations.ApiOperation;
import kr.co.msa_popool.career.web.dto.CareerCreateRequest;
import kr.co.msa_popool.career.service.CareerService;
import kr.co.msa_popool.career.web.dto.CareerResponse;
import kr.co.msa_popool.career.web.dto.CareerUpdateRequest;
import kr.co.msa_popool.infra.ResponseFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/careers")
public class CareerController {

    private final CareerService careerService;

    @ApiOperation("개인 인사 내역 등록")
    @PostMapping
    public ResponseFormat newCareer(@RequestBody CareerCreateRequest request) {
        careerService.createCareer(request);
        return ResponseFormat.ok();
    }


    @ApiOperation("개인 인사 내역 조회")
    @GetMapping
    public ResponseFormat newCareer(@RequestParam String memberId) {
        CareerResponse careerInfo = careerService.showCareer(memberId);
        return ResponseFormat.ok(careerInfo);
    }

    @ApiOperation("개인 인사 내역 수정")
    @PatchMapping
    public ResponseFormat updateCareer(@RequestParam String memberId, @RequestBody CareerUpdateRequest request) {
        careerService.updateCareer(memberId, request);
        return ResponseFormat.ok();
    }

    @ApiOperation("개인 인사 내역 삭제")
    @DeleteMapping
    public ResponseFormat deleteCareer(@RequestParam String memberId) {
        careerService.deleteCareer(memberId);
        return ResponseFormat.ok();
    }
}
