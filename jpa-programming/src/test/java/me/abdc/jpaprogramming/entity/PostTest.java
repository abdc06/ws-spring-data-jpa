package me.abdc.jpaprogramming.entity;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PostTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test @Rollback(false)
    void cascade() {
        Post post = new Post();
        post.setTitle("게시글1");

        Comment comment1 = new Comment();
        comment1.setComment("댓글1");
        post.addComment(comment1);

        Comment comment2 = new Comment();
        comment2.setComment("댓글2");
        post.addComment(comment2);

        Session session = entityManager.unwrap(Session.class);
        session.save(post);
        
        session.delete(post);
    }
}