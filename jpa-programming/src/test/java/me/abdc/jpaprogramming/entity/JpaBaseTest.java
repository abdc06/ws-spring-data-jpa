package me.abdc.jpaprogramming.entity;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaBaseTest {

    @PersistenceContext
    EntityManager entityManager;

    @Test @Rollback(false)
    void entityManagerTest() {
        Account account = new Account();
        account.setUsername("kim");
        account.setPassword("1234");
        account.setCreatedOn(new Date());

        entityManager.persist(account);
    }

    @Test @Rollback(false)
    void sessionTest() {
        Account account = new Account();
        account.setUsername("lee");
        account.setPassword("5678");
        account.setCreatedOn(new Date());

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
    }
}
