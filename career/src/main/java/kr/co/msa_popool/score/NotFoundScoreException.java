package kr.co.msa_popool.score;

import kr.co.msa_popool.exception.ErrorType;

public class NotFoundScoreException extends RuntimeException {

    public NotFoundScoreException() {
        super(String.valueOf(ErrorType.NOT_FOUND_SCORE));
    }
}
