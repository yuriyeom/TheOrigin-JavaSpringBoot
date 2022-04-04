package dev.glassym.mission3_challenge.repository;

import dev.glassym.mission3_challenge.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByName(String writer);
}
