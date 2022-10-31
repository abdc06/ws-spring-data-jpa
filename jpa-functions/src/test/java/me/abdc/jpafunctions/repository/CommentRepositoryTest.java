package me.abdc.jpafunctions.repository;

import me.abdc.jpafunctions.entity.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class CommentRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Test
    void getComment() {
        commentRepository.getCommentById(1L);
        commentRepository.findById(1L);
    }

    @Test
    public void getCommentSummary() {
        saveData();

        List<CommentSummary> byPostId = commentRepository.findByPostId(1L);
        byPostId.forEach(c -> {
            System.out.println("=================");
            System.out.println(c.getVotesOpenProjection());
            System.out.println(c.getVotesCloseProjection());
            System.out.println(c);
        });
    }

    @Test
    public void getCommentSummary2() {
        saveData();

        commentRepository.findByPostId(1L, CommentClass.class);
        commentRepository.findByPostId(1L, CommentOnly.class);
    }

    private void saveData() {
        Post post = new Post();
        post.setTitle("hibernate");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("hello");
        comment.setUp(10);
        comment.setDown(1);
        comment.setPost(savedPost);
        commentRepository.save(comment);
    }

}