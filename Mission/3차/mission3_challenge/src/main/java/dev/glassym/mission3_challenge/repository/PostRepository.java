package dev.glassym.mission3_challenge.repository;

import dev.glassym.mission3_challenge.entity.BoardEntity;
import dev.glassym.mission3_challenge.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
}
