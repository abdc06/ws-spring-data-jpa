package me.abdc.jparelationship.board.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Board {

    @Id
    private String boardId;

    private String boardNm;

    private LocalDateTime created = LocalDateTime.now();
}
