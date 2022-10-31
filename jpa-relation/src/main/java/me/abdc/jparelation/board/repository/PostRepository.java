package me.abdc.jparelation.board.repository;

import me.abdc.jparelation.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, String> {
}
