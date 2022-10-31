package me.abdc.jpafunctions.repository;

import me.abdc.jpafunctions.entity.Comment;
import me.abdc.jpafunctions.entity.CommentSummary;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @EntityGraph(value = "Comment.post")
    Optional<Comment> getCommentById(Long id);

    List<CommentSummary> findByPostId(Long id);

    <T> List<T> findByPostId(Long id, Class<T> type);
}
