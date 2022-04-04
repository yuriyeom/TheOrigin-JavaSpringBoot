package dev.glassym.mission3_challenge.repository;

import dev.glassym.mission3_challenge.entity.AreaEntity;
import dev.glassym.mission3_challenge.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<ShopEntity, Long> {
}
