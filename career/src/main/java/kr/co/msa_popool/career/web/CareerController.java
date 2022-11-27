package kr.co.msa_popool.career.web;


import io.swagger.annotations.ApiOperation;
import kr.co.msa_popool.career.web.dto.CareerCreateRequest;
import kr.co.msa_popool.career.service.CareerService;
import kr.co.msa_popool.career.web.dto.CareerResponse;
import kr.co.msa_popool.career.web.dto.CareerUpdateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/careers")
public class CareerController {

    private final CareerService careerService;

    @ApiOperation("개인 인사 내역 등록")
    @PostMapping
    public ResponseEntity<Void> newCareer(@RequestBody CareerCreateRequest request) {
        careerService.createCareer(request);
        return ResponseEntity.created(URI.create("/careers/career/" + request.getMemberId())).build();
    }

    @ApiOperation("개인 인사 내역 조회")
    @GetMapping
    public ResponseEntity newCareer(@RequestParam String memberId) {
        CareerResponse careerInfo = careerService.showCareer(memberId);
        return ResponseEntity.ok(careerInfo);
    }

    @ApiOperation("개인 인사 내역 수정")
    @PatchMapping
    public void updateCareer(@RequestParam String memberId, @RequestBody CareerUpdateRequest request) {
        careerService.updateCareer(memberId, request);
    }

    @ApiOperation("개인 인사 내역 삭제")
    @DeleteMapping
    public void deleteCareer(@RequestParam String memberId) {
        careerService.deleteCareer(memberId);
    }
}
