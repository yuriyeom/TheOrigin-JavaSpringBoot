package dev.glassym.mission3_basic.repository;

import dev.glassym.mission3_basic.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {

}
