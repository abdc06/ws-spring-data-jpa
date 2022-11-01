package me.abdc.jparelationship.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Ids {

    @Id
    private String tableName;

    private Long nextId;

    @Transient public final static String BOARD = "BOARD";
    @Transient public final static String POST = "POST";
    @Transient public final static String COMMENT = "COMMENT";
    @Transient public final static String BBS = "BBS";
    @Transient public final static String NTT = "NTT";
    @Transient public final static String REPLY = "REPLY";
    @Transient public final static String CODE_GRP = "CDA";
    @Transient public final static String CODE_MST = "CDB";
    @Transient public final static String CODE_DTL = "CDC";
}
