package kr.co.msa_popool.career.service;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.web.dto.CareerCreateRequest;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.exception.NotFoundCareerException;
import kr.co.msa_popool.infra.ResponseFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CareerService {

    private final CareerRepository careerRepository;

    @Transactional
    public ResponseFormat createCareer(CareerCreateRequest request) {
        Career requestCareer = request.toCareer();
        Career savedCareer = careerRepository.save(requestCareer);
        return ResponseFormat.ok(savedCareer);
    }

    @Transactional
    public ResponseFormat showCareer(String memberId) {
        Career career = careerRepository.findByMemberId(memberId)
            .orElseThrow(NotFoundCareerException::new);

        return ResponseFormat.ok(career.toCareerInfo());
    }
}
