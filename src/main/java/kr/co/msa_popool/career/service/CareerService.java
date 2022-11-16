package kr.co.msa_popool.career.service;

import kr.co.msa_popool.career.domain.Career;
import kr.co.msa_popool.career.web.dto.CareerCreateRequest;
import kr.co.msa_popool.career.domain.CareerRepository;
import kr.co.msa_popool.career.web.dto.CareerResponse;
import kr.co.msa_popool.exception.NotFoundCareerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static kr.co.msa_popool.career.domain.Career.DELETED;


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
        Career career = findCareer(memberId);
        return CareerResponse.of(career);
    }

    @Transactional
    public void deleteCareer(String memberId) {
        Career career = findCareer(memberId);
        career.delete();
        careerRepository.save(career);
    }

    private Career findCareer(String memberId) {
        Career career = careerRepository.findByMemberId(memberId)
            .orElseThrow(NotFoundCareerException::new);

        if (career.isDeleted(DELETED)) {
            throw new IllegalStateException("삭제된 인사 내역입니다");
        }

        return career;
    }


}
