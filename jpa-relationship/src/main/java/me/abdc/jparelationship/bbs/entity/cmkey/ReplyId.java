package me.abdc.jparelationship.bbs.entity.cmkey;

import lombok.Data;

import java.io.Serializable;

@Data
public class ReplyId implements Serializable {

    private NttId ntt;

    private String replyId;
}
