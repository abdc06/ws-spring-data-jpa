package me.abdc.jpaprogramming.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @ToString
@Entity
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(20)")
    private String email;

    @Column @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;

    @Transient
    private String useYn;
}
