package kr.co.msa_popool.exception;

public class NotFoundCareerException extends RuntimeException {

    public NotFoundCareerException() {
        super(String.valueOf(ErrorType.NOT_FOUND_CAREER));
    }
}
