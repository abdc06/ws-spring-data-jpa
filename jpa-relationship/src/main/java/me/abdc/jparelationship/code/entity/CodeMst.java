package me.abdc.jparelationship.code.entity;

import lombok.Data;
import me.abdc.jparelationship.code.entity.cmkey.CodeMstId;

import javax.persistence.*;

@Data
@Entity
public class CodeMst {

    @EmbeddedId
    private CodeMstId codeMstId;

    @MapsId("codeGrpId")
    @ManyToOne
    @JoinColumn(name = "codeGrpId")
    private CodeGrp codeGrp;

    private String codeMstNm;

    private String codeMstDesc;
}
