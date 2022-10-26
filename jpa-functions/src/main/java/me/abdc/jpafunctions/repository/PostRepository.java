package me.abdc.jpafunctions.repository;

import me.abdc.jpafunctions.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
