package dev.glassym.exception.repository;

import dev.glassym.exception.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {

}
