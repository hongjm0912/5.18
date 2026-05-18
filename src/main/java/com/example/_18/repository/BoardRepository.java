package com.example._18.repository;

import com.example._18.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    Optional<BoardEntity> findByPosition(Integer position);

    @Query("SELECT COALESCE(MAX(b.position), 0) FROM BoardEntity b")
    Integer findMaxPosition();
}