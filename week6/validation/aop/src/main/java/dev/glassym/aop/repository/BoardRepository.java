package dev.glassym.aop.repository;

import dev.glassym.aop.entity.BoardEntity;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<BoardEntity, Long> {

}
