package org.top.jsonapiservicesolvation.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(1)
public class SecurityFilter extends HttpFilter {

    private final static Logger LOG = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String token = servletRequest.getHeader("key");

        if (token != null && token.equals("secret")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            servletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            LOG.error(servletRequest.getRemoteHost() + servletRequest.getRequestURI() +
                    " Status: Unauthorized " + servletResponse.getStatus());
        }
    }
}

