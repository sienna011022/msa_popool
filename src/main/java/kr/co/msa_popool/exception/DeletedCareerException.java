package kr.co.msa_popool.exception;

public class DeletedCareerException extends RuntimeException{

    public DeletedCareerException(){
        super(String.valueOf(ErrorType.DELETED_CAREER));
    }
}
