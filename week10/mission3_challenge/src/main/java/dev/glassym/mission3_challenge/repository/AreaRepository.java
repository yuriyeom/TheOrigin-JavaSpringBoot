package dev.glassym.mission3_challenge.repository;

import dev.glassym.mission3_challenge.entity.AreaEntity;
import dev.glassym.mission3_challenge.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AreaRepository extends CrudRepository<AreaEntity, Long> {
}
