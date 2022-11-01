package me.abdc.jparelationship.item.entity;

import lombok.Data;
import me.abdc.jparelationship.common.entity.Member;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Orders {

    @Id
    private String orderNo;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToMany
    @JoinTable(name = "ordersItemMap", joinColumns = @JoinColumn(name = "orderNo"), inverseJoinColumns = @JoinColumn(name = "itemId"))
    private Set<Item> items = new HashSet<>();

    private LocalDateTime created = LocalDateTime.now();

}
