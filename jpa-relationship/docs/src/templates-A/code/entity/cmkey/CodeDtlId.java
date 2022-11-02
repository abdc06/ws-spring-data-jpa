package me.abdc.jparelationship.code.entity.cmkey;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class CodeDtlId implements Serializable {

    private CodeMstId codeMstId;

    private String codeDtlId;
}
