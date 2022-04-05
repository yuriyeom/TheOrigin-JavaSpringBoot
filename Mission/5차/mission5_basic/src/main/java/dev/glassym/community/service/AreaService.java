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

    public AreaDto checkClosestArea(Double lat, Double lon){
        // lat과 lon으로 가장 가까운 area 반환
        return null;
    }
}
