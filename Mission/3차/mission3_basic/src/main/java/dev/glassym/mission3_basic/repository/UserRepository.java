package dev.glassym.mission3_basic.repository;

import dev.glassym.mission3_basic.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByName(String writer);
}
