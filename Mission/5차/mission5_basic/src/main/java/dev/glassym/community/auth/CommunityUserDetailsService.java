package dev.glassym.community.auth;

import dev.glassym.community.entity.AreaEntity;
import dev.glassym.community.entity.UserEntity;
import dev.glassym.community.repository.AreaRepository;
import dev.glassym.community.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CommunityUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CommunityUserDetailsService.class);
    private final UserRepository userRepository;
    private final AreaRepository areaRepository;
    private final PasswordEncoder passwordEncoder;

    public CommunityUserDetailsService(
            @Autowired UserRepository userRepository,
            @Autowired AreaRepository areaRepository,
            @Autowired PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.areaRepository = areaRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntity = this.userRepository.findByUsername(username);
        if(userEntity.isEmpty()){
            throw new UsernameNotFoundException("username not found");
        }
        return new User(username, userEntity.get().getPassword(), new ArrayList<>());
    }

    public void createUser(String username, String password, boolean isShopOwner) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        userEntity.setPassword(passwordEncoder.encode(password));

//        AreaEntity randomArea = this.randomArea();
//        userEntity.setResidence(randomArea);

        userEntity.setResidence(null);

        userEntity.setShopOwner(isShopOwner);

        logger.info("is shop owner : " + isShopOwner);
        this.userRepository.save(userEntity);
    }

    private AreaEntity randomArea(){
        List<AreaEntity> areaEntityList = new ArrayList<>();
        Iterable<AreaEntity> areaIterable = this.areaRepository.findAll();
        areaIterable.forEach(areaEntityList::add);
        Random random = new Random();
        return areaEntityList.get(
                random.nextInt(areaEntityList.size())
        );
    }
}
