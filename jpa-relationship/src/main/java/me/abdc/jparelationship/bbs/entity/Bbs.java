package me.abdc.jparelationship.bbs.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Bbs {

    @Id
    String bbsId;

    String bbsNm;

    private LocalDateTime created = LocalDateTime.now();
}
