package dev.glassym.community.auth.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 로그인 성공한 후에 들어오는 객체
@Component
public class SsoCookieHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    private static final int COOKIE_EXPIRY = 30 * 24 * 60 * 60;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws ServletException, IOException {
        logger.info("onAuthenticationSuccess, create new cookie");

        // 쿠키 값을 만든다.
        Cookie loginCookie = new Cookie(
                "likelion_login_cookie",
                "text_value"
        );
        logger.debug("set cookie max age");
        // 쿠키가 얼마동안 유효한지
        loginCookie.setMaxAge(COOKIE_EXPIRY);
        // 쿠키가 어떤 경로에서 조회가능한지
        loginCookie.setPath("/");
        logger.info("set cookie to httpServletResponse");
        response.addCookie(loginCookie);


        super.onAuthenticationSuccess(request, response, authentication);
    }
}
