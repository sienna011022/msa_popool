package kr.co.msa_popool.career.service;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.web.dto.CareerCreateRequest;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.career.web.dto.CareerResponse;
import kr.co.msa_popool.exception.NotFoundCareerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class CareerService {

    private final CareerRepository careerRepository;

    @Transactional
    public void createCareer(CareerCreateRequest request) {
        Career requestCareer = request.toCareer();
        careerRepository.save(requestCareer);
    }

    @Transactional
    public CareerResponse showCareer(String memberId) {
        Career career = careerRepository.findByMemberId(memberId)
            .orElseThrow(NotFoundCareerException::new);
        return CareerResponse.of(career);
    }
}
