package me.abdc.jparelation.common.entity;

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
}
