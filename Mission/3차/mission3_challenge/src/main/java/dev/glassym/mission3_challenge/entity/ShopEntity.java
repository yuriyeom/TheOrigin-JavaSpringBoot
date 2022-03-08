package dev.glassym.mission3_challenge.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Shop")
@Entity
public class ShopEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category;

    // 한 user가 여러 shop을 가지고 있을 수 있다.
    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne(
            targetEntity = AreaEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "area_id")
    private AreaEntity areaEntity;

    @OneToMany(
            targetEntity = ShopPostEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "shopEntity"
    )
    private List<ShopPostEntity> shopPostEntityList = new ArrayList<>();

    @OneToMany(
            targetEntity = ShopReviewEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "shopEntity"
    )
    private List<ShopReviewEntity> ShopReviewEntity = new ArrayList<>();

}
