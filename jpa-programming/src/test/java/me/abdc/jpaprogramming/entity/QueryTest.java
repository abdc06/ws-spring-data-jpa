package me.abdc.jpaprogramming.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class QueryTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test
    void jpqlOrHql(){
        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);

        List<Post> resultList = query.getResultList();
        System.out.println("====================");
        resultList.forEach(System.out::println);
    }

    @Test
    void criteria() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Post> criteria = builder.createQuery(Post.class);
        Root<Post> root = criteria.from(Post.class);
        criteria.select(root);

        List<Post> resultList = entityManager.createQuery(criteria).getResultList();
        System.out.println("====================");
        resultList.forEach(System.out::println);
    }

    @Test
    void nativeQuery() {
        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM POST", Post.class);

        List<Post> resultList = nativeQuery.getResultList();
        System.out.println("====================");
        resultList.forEach(System.out::println);
    }
}
