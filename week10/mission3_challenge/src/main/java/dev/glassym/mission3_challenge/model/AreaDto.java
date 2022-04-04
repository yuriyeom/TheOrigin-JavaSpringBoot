package dev.glassym.mission3_challenge.model;

import dev.glassym.mission3_challenge.entity.AreaEntity;

public class AreaDto {
    private Long id;
    private String regionMajor;
    private String regionMinor;
    private String regionPatch;
    private Double latitude;
    private Double longitude;

    public AreaDto() {
    }

    public AreaDto(Long id, String regionMajor, String regionMinor, String regionPatch, Double latitude, Double longitude) {
        this.id = id;
        this.regionMajor = regionMajor;
        this.regionMinor = regionMinor;
        this.regionPatch = regionPatch;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public AreaDto(AreaEntity areaEntity) {
        this.id = areaEntity.getId();
        this.regionMajor = areaEntity.getRegionMajor();
        this.regionMinor = areaEntity.getRegionMinor();
        this.regionPatch = areaEntity.getRegionPatch();
        this.latitude = areaEntity.getLatitude();
        this.longitude = areaEntity.getLongitude();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegionMajor() {
        return regionMajor;
    }

    public void setRegionMajor(String regionMajor) {
        this.regionMajor = regionMajor;
    }

    public String getRegionMinor() {
        return regionMinor;
    }

    public void setRegionMinor(String regionMinor) {
        this.regionMinor = regionMinor;
    }

    public String getRegionPatch() {
        return regionPatch;
    }

    public void setRegionPatch(String regionPatch) {
        this.regionPatch = regionPatch;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
