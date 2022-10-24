package me.abdc.springdatacommon.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor @Builder
@Getter @Setter @ToString
@Entity
public class Member {

    @Id @GeneratedValue
    private Long no;

    @Column(nullable = false, unique = true)
    private String memberId;

    @Column(nullable = false)
    private String memberName;

    private String email;

    private String phone;

    private Integer age;

    private LocalDateTime createdOn;
}
