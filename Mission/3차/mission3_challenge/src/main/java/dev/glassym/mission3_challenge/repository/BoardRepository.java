package dev.glassym.mission3_challenge.repository;

import dev.glassym.mission3_challenge.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {
}
