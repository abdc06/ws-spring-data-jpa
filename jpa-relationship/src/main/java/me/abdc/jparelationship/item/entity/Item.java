package me.abdc.jparelationship.item.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Item {

    @Id
    private String itemId;

    private String itemNm;

    private int price;
}
