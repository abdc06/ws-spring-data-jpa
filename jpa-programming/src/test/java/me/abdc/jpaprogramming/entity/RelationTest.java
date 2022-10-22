package me.abdc.jpaprogramming.entity;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class RelationTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test @Rollback(false)
    void create() {
        Account account = new Account();
        account.setUsername("kim");
        account.setPassword("1234");

        Study study = new Study();
        study.setName("Spring Data JPA");
        account.addStudy(study);

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        session.save(study);
    }
}
