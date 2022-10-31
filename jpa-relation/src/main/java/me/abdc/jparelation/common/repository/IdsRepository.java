package me.abdc.jparelation.common.repository;

import me.abdc.jparelation.common.entity.Ids;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdsRepository extends JpaRepository<Ids, String> {

    Optional<Ids> findByTableNameIgnoreCase(String tableName);
}
