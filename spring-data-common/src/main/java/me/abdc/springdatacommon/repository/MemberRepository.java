package me.abdc.springdatacommon.repository;

import me.abdc.springdatacommon.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends MyRepository<Member, Long> {

    Optional<Member> findByMemberIdIgnoreCase(String memberId);

    List<Member> findByMemberNameContains(String memberName);

}
