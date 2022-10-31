package me.abdc.jpafunctions.repository;

import me.abdc.jpafunctions.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

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

    @Test
    void findByTitleStartsWith() {
        savePost();

        List<Post> all = postRepository.findByTitleStartsWith("Spring");
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void findByHitsGreaterThanEqual() {
        savePost();

        List<Post> all = postRepository.findByHitsGreaterThanEqual(5);
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void findByTitleIsNotNull() {
        savePost();

        List<Post> all = postRepository.findByTitleIsNotNull();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void findByTitleIgnoreCase() {
        savePost();

        Optional<Post> post = postRepository.findByTitleIgnoreCase("spRIng DaTa JPa");
        assertThat(post.get()).isNotNull();
    }

    @Test
    void sortedFindAll() {
        savePost();

        List<Post> title = postRepository.findAll(Sort.by("title"));
        assertThat(title.size()).isEqualTo(1);
    }

    @Test
    void updateTitle() {
        Post post = savePost();

        String hibernate = "hibernate";
        int update = postRepository.updateTitle(hibernate, post.getId());
        assertThat(update).isEqualTo(1);

        Optional<Post> byId = postRepository.findById(post.getId());
        assertThat(byId.get().getTitle()).isEqualTo(hibernate);
    }

    private Post savePost() {
        Post post = new Post();
        post.setTitle("Spring Data JPA");
        post.setHits(10);
        return postRepository.save(post);
    }
}