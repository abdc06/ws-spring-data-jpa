package me.abdc.jparelationship.member.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Member {

    @Id
    private String memberId;

    private String memberNm;

    private String email;

    private String phone;

    private LocalDateTime created = LocalDateTime.now();
}
