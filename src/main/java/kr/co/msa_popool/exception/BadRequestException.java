package kr.co.msa_popool.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(String.format("Bad Request : %s", message));
    }
}

