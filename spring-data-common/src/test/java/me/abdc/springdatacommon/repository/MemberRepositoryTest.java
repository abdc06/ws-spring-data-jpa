package me.abdc.springdatacommon.repository;

import me.abdc.springdatacommon.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test @Rollback(false)
    void makeQuery() {
        Optional<Member> idIgnoreCase = memberRepository.findByMemberIdIgnoreCase("UOEHNDT03P");

        assertThat(idIgnoreCase.isEmpty()).isFalse();

        List<Member> nameContains = memberRepository.findByMemberNameContains("연조");

        assertThat(nameContains.size()).isEqualTo(1);

        List<Member> desc = memberRepository.findByMemberIdContainsAndPhoneContainsOrderByCreatedOnDesc("z", "08");
        desc.forEach(System.out::println);

        Page<Member> ageGreaterThan = memberRepository.findByAgeGreaterThan(20, PageRequest.of(1, 10));
        assertThat(ageGreaterThan.getTotalElements()).isEqualTo(6L);
    }
}