package me.abdc.commonweb.web;

import me.abdc.commonweb.entity.Post;
import me.abdc.commonweb.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PostRepository postRepository;

    @Test
    void getPost() throws Exception {
        Post post = new Post();
        post.setTitle("JPA");
        postRepository.save(post);

        mockMvc.perform(get("/posts/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("JPA"));
    }

    @Test
    void getPosts() throws Exception {
        Post post = new Post();
        post.setTitle("JPA");
        postRepository.save(post);

        mockMvc.perform(get("/posts")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sort", "createdOn,desc")
                        .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content[0].title", is("JPA")));
    }

    @Test
    void getHateoasPosts() throws Exception {
        createPosts();

        mockMvc.perform(get("/hateoasPosts")
                        .param("page", "0")
                        .param("size", "10")
                        .param("sort", "createdOn,desc")
                        .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private void createPosts() {
        IntStream.range(0, 100).forEach(i -> {
            Post post = new Post();
            post.setTitle("JPA");
            postRepository.save(post);
        });
    }

}