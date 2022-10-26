package me.abdc.jpafunctions.repository;

import me.abdc.jpafunctions.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PostsRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    void save() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post); //transient -> persistent (persist)

        Post newPost = new Post();
        newPost.setId(savedPost.getId());
        newPost.setTitle("hibernate");

        assertThat(entityManager.contains(post)).isTrue();
        assertThat(entityManager.contains(savedPost)).isTrue();

        Post updatedPost = postRepository.save(newPost);    //detached -> persistent (merge)

        newPost.setTitle("boot");   //newPost는 JPA가 관리하지 않기 떄문에 업데이트 쿼리가 발생하지 않음.

        assertThat(entityManager.contains(newPost)).isFalse();
        assertThat(entityManager.contains(updatedPost)).isTrue();

        List<Post> all = postRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }
}