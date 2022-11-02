package me.abdc.jparelationship.bbs.entity;

import lombok.Data;
import me.abdc.jparelationship.bbs.entity.cmkey.ReplyId;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@IdClass(ReplyId.class)
@Entity
public class Reply {

    @Id
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "bbsId"), @JoinColumn(name = "nttId")})
    private Ntt ntt;

    @Id
    private String replyId;

    private String content;

    private LocalDateTime created = LocalDateTime.now();
}
