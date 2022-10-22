package me.abdc.jpaprogramming.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @ToString
@Entity
public class Account {

    @Id @GeneratedValue
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

    @OneToMany(mappedBy = "owner")
    private Set<Study> studies = new HashSet<>();

    public void addStudy(Study study) {
        study.setOwner(this);
        studies.add(study);
    }

    public void removeStudy(Study study) {
        study.setOwner(null);
        studies.remove(study);
    }
}
