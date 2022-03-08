package dev.glassym.mission3_challenge.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name="area")
@Entity
public class AreaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String province; // 도,광역시
    private String city; // 시,군,구
    private String dong; // 동,면,읍
    private double lat; //위도
    private double lon; // 경도

    @OneToMany(
            targetEntity = UserEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "areaEntity"
    )
    private List<UserEntity> userEntityList = new ArrayList<>();

    @OneToMany(
            targetEntity = ShopEntity.class,
            fetch = FetchType.LAZY,
            mappedBy = "areaEntity"
    )
    private List<ShopEntity> shopEntityList = new ArrayList<>();

    public AreaEntity() {
    }

    public AreaEntity(Long id, String province, String city, String dong, double lat, double lon) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.dong = dong;
        this.lat = lat;
        this.lon = lon;
    }

    public Long getId() {
        return id;
    }

    public String getProvince() {
        return province;
    }

    public String getCity() {
        return city;
    }

    public String getDong() {
        return dong;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
