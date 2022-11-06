package me.abdc.jparelationship.common.repository;

import me.abdc.jparelationship.common.TableName;
import me.abdc.jparelationship.common.entity.Ids;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IdsRepository extends JpaRepository<Ids, String> {

    Optional<Ids> findByTableName(TableName tableName);
}
