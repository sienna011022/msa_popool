package kr.co.msa_popool.score;

import io.swagger.annotations.ApiOperation;
import kr.co.msa_popool.infra.ResponseFormat;
import kr.co.msa_popool.score.service.ScoreService;
import kr.co.msa_popool.score.web.dto.ScoreCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/scores")
public class ScoreController {

    private final ScoreService scoreService;

    @ApiOperation("개인 인사 내역 등록")
    @PostMapping
    public ResponseFormat newScore(@RequestParam String memberId,@RequestBody ScoreCreateRequest request) {
        scoreService.newScore(memberId,request);
        return ResponseFormat.ok();
    }
}
