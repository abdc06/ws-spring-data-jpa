package me.abdc.springdatacommon.repository;

import me.abdc.springdatacommon.entity.Comment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    void select() {
        List<Comment> comments = commentRepository.findAll();
        long count = commentRepository.count();

        assertEquals(count, comments.size());
    }

    @Test
    void selectOne() {
        Optional<Comment> byId = commentRepository.findById(100L);

        assertTrue(byId.isPresent());
        assertFalse(byId.isEmpty());
    }

    @Test
    void nullCheck() {
        assertThrows(InvalidDataAccessApiUsageException.class, () -> {
            commentRepository.save(null);
        });
    }
        
}