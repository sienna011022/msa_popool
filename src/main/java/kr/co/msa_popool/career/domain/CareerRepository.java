package kr.co.msa_popool.career.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CareerRepository extends JpaRepository<Career,Long> {
    Optional<Career> findByMemberId(String memberId);
}
