package me.abdc.jparelationship.code.entity.cmkey;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;


@Data
@Embeddable
public class CodeMstId implements Serializable {

    private String codeGrpId;

    private String codeMstId;
}
