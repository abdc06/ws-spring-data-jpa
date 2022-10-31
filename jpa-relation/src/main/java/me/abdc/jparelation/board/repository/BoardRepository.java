package me.abdc.jparelation.board.repository;

import me.abdc.jparelation.board.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {
}
