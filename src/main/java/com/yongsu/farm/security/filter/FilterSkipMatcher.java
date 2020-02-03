package com.yongsu.farm.security.filter;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zzai_sang
 * @version 0.1.0
 * @since 2020-02-03
 */
public class FilterSkipMatcher implements RequestMatcher {

    private OrRequestMatcher orRequestMatcher;
    private RequestMatcher processingMatcher;

    public FilterSkipMatcher(List<String> pathToSkip,  String processingPath) {
        this.orRequestMatcher = new OrRequestMatcher(pathToSkip.stream().map(AntPathRequestMatcher::new).collect(Collectors.toList()));
        this.processingMatcher = new AntPathRequestMatcher(processingPath);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return orRequestMatcher.matches(request) && processingMatcher.matches(request);
    }
}
