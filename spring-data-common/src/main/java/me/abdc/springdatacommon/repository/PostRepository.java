package me.abdc.springdatacommon.repository;

import me.abdc.springdatacommon.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
