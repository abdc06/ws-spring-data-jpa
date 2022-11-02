package me.abdc.jparelationship.bbs.entity;

import lombok.Data;
import me.abdc.jparelationship.bbs.entity.cmkey.NttId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@IdClass(NttId.class)
@Entity
public class Ntt {

    @Id
    @ManyToOne
    @JoinColumn(name = "bbsId")
    private Bbs bbs;

    @Id
    private String nttId;

    private String title;

    private LocalDateTime created = LocalDateTime.now();
}
