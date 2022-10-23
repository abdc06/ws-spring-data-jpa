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

    @Test @Rollback(false)
    void fetch() {
        Session session = entityManager.unwrap(Session.class);
        Post post = session.get(Post.class, 1L);
        System.out.println("======================");
        System.out.println(post);
        post.getComments().forEach(c -> {
            System.out.println("-------------------");
            System.out.println(c);
        });

        Comment comment = session.get(Comment.class, 188L);
        System.out.println("======================");
        System.out.println(comment);
    }

    @Test @Rollback(false)
    void initSampleData() {
        Session session = entityManager.unwrap(Session.class);

        for (int i = 0; i < 50; i++) {
            Post post = new Post();
            post.setTitle("샘플용 게시물" + i);

            for (int j = 0; j < 5; j++) {
                Comment comment = new Comment();
                comment.setComment("댓글[" + i + "/" + j + "]");
                post.addComment(comment);
            }
            session.save(post);
        }
    }


}