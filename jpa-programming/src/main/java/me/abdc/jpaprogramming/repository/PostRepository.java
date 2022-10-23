package me.abdc.jpaprogramming.repository;

import me.abdc.jpaprogramming.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
