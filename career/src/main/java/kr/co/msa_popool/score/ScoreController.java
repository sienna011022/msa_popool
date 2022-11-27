package kr.co.msa_popool.score;

import io.swagger.annotations.ApiOperation;
import kr.co.msa_popool.infra.ResponseFormat;
import kr.co.msa_popool.score.web.dto.ScoreResponses;
import kr.co.msa_popool.score.service.ScoreService;
import kr.co.msa_popool.score.web.dto.ScoreCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/scores")
public class ScoreController {

    private final ScoreService scoreService;

    @ApiOperation("평가 내역 등록")
    @PostMapping
    public ResponseFormat newScore(@RequestBody ScoreCreateRequest request) {
        scoreService.newScore(request);
        return ResponseFormat.ok();
    }

    @ApiOperation("자신이 등록한 모든 평가 내역 조회")
    @GetMapping
    public ResponseEntity showAll(@RequestParam String evaluatorId) {
        return ResponseEntity.ok(scoreService.showScoreAllByEvaluator(evaluatorId));
    }

    @ApiOperation("자신에게 평가된 모든 평가 내역 조회")
    @GetMapping("/all")
    public ResponseEntity<ScoreResponses> showAllMyScores(@RequestParam String memberId) {
        return ResponseEntity.ok(scoreService.showMyAllScore(memberId));
    }

}
