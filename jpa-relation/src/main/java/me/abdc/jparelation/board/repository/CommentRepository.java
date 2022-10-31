package me.abdc.jparelation.board.repository;

import me.abdc.jparelation.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
