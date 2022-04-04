package dev.glassym.mission3_challenge.repository;

import dev.glassym.mission3_challenge.entity.AreaEntity;
import dev.glassym.mission3_challenge.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Long> {
}
