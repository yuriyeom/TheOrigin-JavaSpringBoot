package dev.glassym.mission3_challenge.entity;

import javax.persistence.*;

@Table(name = "ShopReview")
@Entity
public class ShopReviewEntity {
    // 리뷰는 아무나
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne(
            targetEntity = BoardEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;

    @ManyToOne(
            targetEntity = ShopEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "shop_id")
    private ShopEntity shopEntity;

    @ManyToOne(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;


}
