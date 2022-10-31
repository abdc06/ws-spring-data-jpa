package me.abdc.jparelationship.common.repository;

import me.abdc.jparelationship.common.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
