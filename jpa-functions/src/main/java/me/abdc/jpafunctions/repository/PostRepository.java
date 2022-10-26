package me.abdc.jpafunctions.repository;

import me.abdc.jpafunctions.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    /**
     * TODO And, Or
     * TODO Is, Equals
     * TODO LessThan, LessThanEqual, GreaterThan, GreaterThanEqual
     * TODO After, Before
     * TODO IsNull, IsNotNull, NotNull
     * TODO Like, NotLike
     * TODO StartingWith, EndingWith, Containing
     * TODO OrderBy
     * TODO Not, In, NotIn
     * TODO True, False
     * TODO IgnoreCase
     */
    List<Post> findByTitleStartsWith(String title);

    List<Post> findByHitsGreaterThanEqual(int hits);

    List<Post> findByTitleIsNotNull();

    Optional<Post> findByTitleIgnoreCase(String title);

}
