package kr.co.msa_popool.career.service;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.domain.CareerCreateRequest;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.infra.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CareerService {

    private final CareerRepository careerRepository;

    public ResponseFormat createCareer(CareerCreateRequest request){
        Career requestCareer = request.toCareer();
        Career savedCareer = careerRepository.save(requestCareer);
        return ResponseFormat.ok(savedCareer);
    }
}
