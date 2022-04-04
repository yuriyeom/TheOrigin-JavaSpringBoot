package dev.glassym.mission3_challenge.repository;

import dev.glassym.mission3_challenge.entity.ShopEntity;
import dev.glassym.mission3_challenge.entity.ShopReviewEntity;
import org.springframework.data.repository.CrudRepository;

public interface ShopReviewRepository extends CrudRepository<ShopReviewEntity, Long> {
}
