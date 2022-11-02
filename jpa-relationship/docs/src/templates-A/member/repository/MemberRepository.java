package me.abdc.jparelationship.member.repository;

import me.abdc.jparelationship.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
