package me.abdc.jparelation.board.entity;

import lombok.Data;
import me.abdc.jparelation.common.entity.Member;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@Entity
public class Post {

    @Id
    private String postId;

    private String title;

    private LocalDateTime created = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "ownerId")
    private Member owner;

    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;
}
