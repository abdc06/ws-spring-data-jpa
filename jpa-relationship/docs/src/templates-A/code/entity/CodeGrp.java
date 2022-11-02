package me.abdc.jparelationship.code.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CodeGrp {

    @Id
    private String codeGrpId;

    private String codeGrpNm;

    private String codeGrpDesc;
}
