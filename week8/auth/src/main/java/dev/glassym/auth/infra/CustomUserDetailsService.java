package dev.glassym.auth.infra;

import dev.glassym.auth.entity.UserEntity;
import dev.glassym.auth.entity.UserRepository;
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

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetailsService(
            @Autowired UserRepository userRepository,
            @Autowired PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        final UserEntity testUserEntity = new UserEntity();
        testUserEntity.setUsername("entity_user");
        testUserEntity.setPassword(passwordEncoder.encode("test1pass"));
        this.userRepository.save(testUserEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByUsername(username);
        // UserEntity -> UserDetails
        return new User(username, userEntity.getPassword(), new ArrayList<>());
    }
    // UserDetails 안에 유저 닉네임, 비밀번호같은 정보가 들어있음
}
