package me.abdc.jparelationship.code.entity;

import lombok.Data;
import me.abdc.jparelationship.code.entity.cmkey.CodeDtlId;

import javax.persistence.*;

@Data
@Entity
public class CodeDtl {

    @EmbeddedId
    private CodeDtlId codeDtlId;

    @MapsId(value = "codeMstId")
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "codeGrpId"), @JoinColumn(name = "codeMstId")})
    private CodeMst codeMst;

    private String codeVal;

    private String codeNm;

    private String codeDesc;
}
