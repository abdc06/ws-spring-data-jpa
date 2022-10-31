package me.abdc.jparelationship.bbs.entity.cmkey;

import lombok.Data;

import java.io.Serializable;

@Data
public class NttId implements Serializable {

    private String bbs;

    private String nttId;
}
