package dev.glassym.mission3_basic.repository;

import dev.glassym.mission3_basic.entity.UserEntity;
import dev.glassym.mission3_basic.model.UserDto;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.Optional;

@Repository
public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
    private final UserRepository userRepository;

    public UserDao(
            @Autowired UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    public void createUser(UserDto dto){
        UserEntity userEntity = UserEntity.builder(dto).build();
        this.userRepository.save(userEntity);
    }

    public UserEntity readUser(int id){
        Optional<UserEntity> userEntity = this.userRepository.findById((long) id);
        if(userEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userEntity.get();
    }

    public Iterator<UserEntity> readUserAll(){
        return this.userRepository.findAll().iterator();
    }

    public UserEntity readUserByWriter(String writer){
        Optional<UserEntity> userEntity = this.userRepository.findByName(writer);
        if(userEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return userEntity.get();
    }

    public void updateUser(int id, UserDto dto){
        Optional<UserEntity> targetEntity = this.userRepository.findById((long) id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        UserEntity userEntity = targetEntity.get();
        UserEntity resultEntity = UserEntity.builder(new UserDto(userEntity.getId(), userEntity.getName(), dto.getPassword())).build();
        this.userRepository.save(resultEntity);
    }

    public void deleteUser(int id){
        Optional<UserEntity> targetEntity = this.userRepository.findById((long) id);
        if(targetEntity.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        this.userRepository.delete(targetEntity.get());
    }


}
