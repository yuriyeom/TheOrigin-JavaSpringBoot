package dev.glassym.community.service;

import dev.glassym.community.controller.dto.AreaDto;
import dev.glassym.community.entity.AreaEntity;
import dev.glassym.community.repository.AreaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    private static final Logger logger = LoggerFactory.getLogger(AreaService.class);
    private final AreaRepository areaRepository;

    public AreaService(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
        AreaEntity areaEntity1 = new AreaEntity((long)1, "서울시", "서초구", "서초동",37.4877 ,127.0174);
        AreaEntity areaEntity2 = new AreaEntity((long)2, "서울시", "강남구", "역삼동",37.4999 ,127.0374);
        AreaEntity areaEntity3 = new AreaEntity((long)3, "서울시", "강남구", "삼성동",37.5140 ,127.0565);
        this.areaRepository.save(areaEntity1);
        this.areaRepository.save(areaEntity2);
        this.areaRepository.save(areaEntity3);
    }

    public AreaDto createArea(AreaDto areaDto){
        AreaEntity areaEntity = new AreaEntity();
        areaEntity.setRegionMajor(areaDto.getRegionMajor());
        areaEntity.setRegionMinor(areaDto.getRegionMinor());
        areaEntity.setRegionPatch(areaDto.getRegionPatch());
        areaEntity.setLatitude(areaDto.getLatitude());
        areaEntity.setLongitude(areaDto.getLongitude());
        areaEntity = areaRepository.save(areaEntity);

        return new AreaDto(areaEntity);
    }

    public AreaDto readArea(Long id) {
        Optional<AreaEntity> areaEntityOptional = areaRepository.findById(id);
        if (areaEntityOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new AreaDto(areaEntityOptional.get());
    }

    public List<AreaDto> readAreaAll(){
        List<AreaDto> areaDtoList = new ArrayList<>();
        areaRepository.findAll().forEach(areaEntity -> areaDtoList.add(new AreaDto(areaEntity)));
        return areaDtoList;
    }

    public AreaDto findClosestArea(Double lat, Double lon){
        // lat과 lon으로 가장 가까운 area 반환
        // 가장 가까운 ? 위도, 경도 차이가 제일 적은걸로 했다.
        List<AreaDto> areaDtoList = this.readAreaAll();
        Double min = 1000.0;
        long find = 0;
        for(AreaDto area : areaDtoList){
            logger.info(area.toString());
            Double tmpLat = area.getLatitude();
            Double tmpLon = area.getLongitude();

            Double value = haversine(lat, lon, tmpLat, tmpLon);
            if(min > value){
                min = value;
                find = area.getId();
            }
        }
        Optional<AreaEntity> target = this.areaRepository.findById(find);
        if(target.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        AreaDto areaDto = new AreaDto();
        areaDto.setId(find);
        areaDto.setRegionMajor(target.get().getRegionMajor());
        areaDto.setRegionMinor(target.get().getRegionMinor());
        areaDto.setRegionPatch(target.get().getRegionPatch());
        areaDto.setLatitude(target.get().getLatitude());
        areaDto.setLongitude(target.get().getLongitude());
        logger.info(areaDto.toString());
        return areaDto;
    }


    // 두 지점의 거리를 위도, 경도로 계산하는 함수
    public static final double R = 6372.8; // In kilometers
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }

    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
