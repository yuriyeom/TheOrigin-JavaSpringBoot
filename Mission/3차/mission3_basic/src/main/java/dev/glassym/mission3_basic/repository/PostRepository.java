package dev.glassym.mission3_basic.repository;

import dev.glassym.mission3_basic.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
