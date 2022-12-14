package me.abdc.jparelationship.board.entity;

import lombok.Data;
import me.abdc.jparelationship.common.entity.Member;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    private String commentId;

    private String comment;

    private LocalDateTime created = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Member owner;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;
}
