package com.yongsu.farm.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yongsu.farm.dto.api.ApiResult;
import com.yongsu.farm.dto.api.ApiResultMaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-04
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        final ApiResult apiResult = ApiResultMaker.unauthorized();

        final String body = objectMapper.writeValueAsString(apiResult);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().write(body);
    }
}
