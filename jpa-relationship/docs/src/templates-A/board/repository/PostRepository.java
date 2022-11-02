package me.abdc.jparelationship.board.repository;

import me.abdc.jparelationship.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
