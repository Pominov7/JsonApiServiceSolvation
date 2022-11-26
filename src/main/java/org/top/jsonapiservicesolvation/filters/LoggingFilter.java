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
@Order(2)
public class LoggingFilter extends HttpFilter {

    private final static Logger LOG = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public void init(FilterConfig filterConfig) {
        LOG.info("Initializing filter :{}", this);
    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(request, response);
        if (response.getStatus() >= 200 & response.getStatus() < 300) {
            LOG.info(request.getRemoteHost() + request.getRequestURI() +
                    " Status: OK " + response.getStatus());

        } else if (response.getStatus() >= 300 & response.getStatus() < 400) {
            LOG.error(request.getRemoteHost() + request.getRequestURI() +
                    " Status: Redirect " + response.getStatus());

        } else if (response.getStatus() >= 400 & response.getStatus() < 500) {
            LOG.error(request.getRemoteHost() + request.getRequestURI() +
                    " Status: Client-side error " + response.getStatus());

        } else if (response.getStatus() >= 500 & response.getStatus() < 600) {
            LOG.error(request.getRemoteHost() + request.getRequestURI() +
                    " Status: Server-side error " + response.getStatus());
        }
    }

    @Override
    public void destroy() {
        LOG.warn("Destructing filter :{}", this);
    }
}
