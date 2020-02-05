package com.yongsu.farm.security;

import com.yongsu.farm.security.filter.FilterSkipMatcher;
import com.yongsu.farm.security.filter.JwtAuthenticationFilter;
import com.yongsu.farm.security.handler.JwtAuthenticationFailureHandler;
import com.yongsu.farm.security.jwt.HeaderTokenExtractor;
import com.yongsu.farm.security.provider.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.List;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020/01/30
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final JwtAuthenticationFailureHandler jwtAuthenticationFailureHandler;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final HeaderTokenExtractor headerTokenExtractor;

    public SecurityExpressionHandler expressionHandler() {
        final RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_ROOT > ROLE_USER");

        final DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
        handler.setRoleHierarchy(roleHierarchy);
        return handler;
    }

    private JwtAuthenticationFilter jwtAuthenticationFilter()throws Exception{
        final List<String> pathToSkip = Arrays.asList("/login","/refresh");

        final var processing = "/**";
        final FilterSkipMatcher filterSkipMatcher = new FilterSkipMatcher(pathToSkip, processing);
        final var jwtAuthenticationFilter = new JwtAuthenticationFilter(filterSkipMatcher, headerTokenExtractor, jwtAuthenticationFailureHandler);
        jwtAuthenticationFilter.setAuthenticationManager(super.authenticationManager());
        return jwtAuthenticationFilter;
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .mvcMatchers("/health","/v1/product/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //HttpSession 생성 하지 않음
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        //Cross-site Request Forgery Protection Disable
        http
                .csrf()
                .disable();

        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .expressionHandler(expressionHandler());

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}
