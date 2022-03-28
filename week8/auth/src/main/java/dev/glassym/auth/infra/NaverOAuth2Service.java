package dev.glassym.auth.infra;

import dev.glassym.auth.entity.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
public class NaverOAuth2Service implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private static final Logger logger = LoggerFactory.getLogger(NaverOAuth2Service.class);
    private final UserRepository userRepository;

    public NaverOAuth2Service(
            @Autowired UserRepository userRepository
    ){
        this.userRepository = userRepository;
    }

    // oauth과정이 전부 다 일어난 다음에 이 함수에 들어가 사용자 정보가 돌아오게 된다.
    // 내 서비스에 어떤 형태로 사용할건지 정의하는 곳
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);
        // oAuth2User 객체에 사용자 정보가 들어가있는 상태

        // 사용자 이름을 지정하는 이름이 무엇인지
       String nameAttributeKey = userRequest
               .getClientRegistration() // 현재 들어온 요청이 yml에 정의한 registration 중 어떤건지
               .getProviderDetails() // yml 속 registration 아래 naver에 대한 디테일들
               .getUserInfoEndpoint() // 유저 정보를 어디에서 받아오는지
               .getUserNameAttributeName();

       Map<String, Object> attributeMap = oAuth2User.getAttributes();
        Map<String, Object> responseMap = (Map<String, Object>) attributeMap.get("response");
        DefaultOAuth2User defaultOAuth2User = new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                responseMap,
                "email"
        );

        return defaultOAuth2User;
    }
}
