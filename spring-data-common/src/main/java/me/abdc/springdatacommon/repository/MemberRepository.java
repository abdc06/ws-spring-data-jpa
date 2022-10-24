package me.abdc.springdatacommon.repository;

import me.abdc.springdatacommon.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MyRepository<Member, Long> {

    Optional<Member> findByMemberIdIgnoreCase(String memberId);

    List<Member> findByMemberNameContains(String memberName);

    List<Member> findByMemberIdContainsAndPhoneContainsOrderByCreatedOnDesc(String memberId, String phone);

    Page<Member> findByAgeGreaterThan(int age, Pageable pageable);

}
