package me.abdc.commonweb.repository;

import me.abdc.commonweb.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
