package me.abdc.springdatacommon.repository;

import me.abdc.springdatacommon.entity.Comment;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {

    List<T> findAll();

    Optional<T> findById(Id id);

    <E extends T> E save(E entity);

    void deleteById(Id id);
}
