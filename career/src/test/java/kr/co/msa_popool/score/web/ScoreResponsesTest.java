package kr.co.msa_popool.score.web;

import kr.co.msa_popool.score.web.dto.ScoreResponse;
import kr.co.msa_popool.score.web.dto.ScoreResponses;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class ScoreResponsesTest {

    @Test
    void 평가_응답_일급컬렉션(){
        assertThat(new ScoreResponses(Arrays.asList(new ScoreResponse()))).isInstanceOf(ScoreResponses.class);
    }
}
