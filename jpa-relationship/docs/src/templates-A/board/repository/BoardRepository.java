package me.abdc.jparelationship.board.repository;

import me.abdc.jparelationship.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {
}
