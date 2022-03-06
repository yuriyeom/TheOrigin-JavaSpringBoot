package dev.glassym.mission3_basic.service;

import dev.glassym.mission3_basic.entity.UserEntity;
import dev.glassym.mission3_basic.model.UserDto;
import dev.glassym.mission3_basic.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(BoardService.class);
    private final UserDao userDao;

    public UserService(
            @Autowired UserDao userDao
    ){
        this.userDao = userDao;
    }

    public void createUser(UserDto dto){
        this.userDao.createUser(dto);
    }

    public UserDto readUser(int id){
        UserEntity userEntity = this.userDao.readUser(id);
        return new UserDto(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getPassword()
        );
    }

    public List<UserDto> readUserAll(){
        Iterator<UserEntity> iterator = this.userDao.readUserAll();
        List<UserDto> userDtoList = new ArrayList<>();
        while(iterator.hasNext()){
            UserEntity userEntity = iterator.next();
            userDtoList.add(new UserDto(
                    userEntity.getId(),
                    userEntity.getName(),
                    userEntity.getPassword()
            ));
        }
        return userDtoList;
    }

    public void updateUser(int id, UserDto dto){
        this.userDao.updateUser(id, dto);
    }

    public void deleteUser(int id){
        this.userDao.deleteUser(id);
    }

}
