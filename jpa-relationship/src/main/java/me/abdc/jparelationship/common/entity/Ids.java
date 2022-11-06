package me.abdc.jparelationship.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.abdc.jparelationship.common.TableName;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;


@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Ids {

    @Id
    @Enumerated(value = EnumType.STRING)
    private TableName tableName;

    private Long nextId;
}