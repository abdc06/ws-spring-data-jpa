package me.abdc.jparelationship.board.repository;

import me.abdc.jparelationship.board.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
}
