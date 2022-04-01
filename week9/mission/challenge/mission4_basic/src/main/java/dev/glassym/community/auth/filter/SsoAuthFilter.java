package dev.glassym.community.auth.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

import static dev.glassym.community.auth.LikelionSsoConsts.LIKELION_LOGIN_COOKIE;

@Component
public class SsoAuthFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(SsoAuthFilter.class);

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        Optional<String> authToken = authTokenFromCookie(httpRequest.getCookies());
        if(authToken.isEmpty()){
            authToken = authTokenFromQuery(httpRequest, httpResponse);
        }

        if(authToken.isPresent()){
            this.setSsoAuthentication(authToken.get());
        }else{
            SecurityContextHolder.getContext().setAuthentication(
                    new AnonymousAuthenticationToken(
                            "anonymous",
                            "anonymous",
                            Collections.singletonList(
                                    (GrantedAuthority) () -> "ROLE_ANONYMOUS")
                    )
            );
        }
    }

    private Optional<String> authTokenFromCookie(Cookie[] cookies){
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(LIKELION_LOGIN_COOKIE)){
                    return Optional.of(cookie.getValue());
                }
            }
        }
        return Optional.empty();
    }

    private Optional<String> authTokenFromQuery(
        HttpServletRequest httpRequest,
        HttpServletResponse httpResponse
    ){
        String queryString = httpRequest.getQueryString();
        if(queryString == null){
            return Optional.empty();
        }
        String[] queryParams = queryString.split("&");
        for(String queryParam: queryParams){
            String[] queryParamSplit = queryParam.split("=");
            if(queryParamSplit.length == 1) continue;
            if(queryParamSplit[0].equals(LIKELION_LOGIN_COOKIE)){
                String loginToken = queryParamSplit[1];
                Cookie newTokenCookie = new Cookie(LIKELION_LOGIN_COOKIE, loginToken);
                newTokenCookie.setPath("/");
                httpResponse.addCookie(newTokenCookie);
                return Optional.of(queryParamSplit[1]);
            }
        }
        return Optional.empty();

    }

    private void setSsoAuthentication(String tokenValue){
        // tokenValue가 유효한지 Auth 서버에 요청을 보내고 응답을 받는 부분
        // TODO create new Authentication based on token

        SecurityContextHolder.getContext().setAuthentication(new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return Collections.emptyList();
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return (Principal) () -> "dummy";
            }

            @Override
            public boolean isAuthenticated() {
                return true;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return "dummy";
            }
        });
    }
}
