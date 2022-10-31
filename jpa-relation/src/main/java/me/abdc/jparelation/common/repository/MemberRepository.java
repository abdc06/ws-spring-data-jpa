package me.abdc.jparelation.common.repository;

import me.abdc.jparelation.common.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
