package me.abdc.jpafunctions.repository;

import me.abdc.jpafunctions.entity.Post;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

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

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Post p SET p.title = ?1 WHERE p.id = ?2")
    int updateTitle(String hibernate, Long id);
}
