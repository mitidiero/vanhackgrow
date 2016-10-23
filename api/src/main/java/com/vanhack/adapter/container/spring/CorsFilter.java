package com.vanhack.adapter.container.spring;

import com.google.common.net.HttpHeaders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter implements Filter {

    @Value("${authentication.corsFilterEnabled}")
    private boolean corsFilterEnabled;

    /**
     * Set up CORS so cross domain requests can be sent.
     */
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        if (corsFilterEnabled) {
            final HttpServletRequest corsRequest = (HttpServletRequest) request;
            final HttpServletResponse corsResponse = (HttpServletResponse) response;
            corsResponse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:3000");
            corsResponse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
                    "POST, GET, PUT, OPTIONS, DELETE, HEAD, PATCH");
            corsResponse.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "3600");
            corsResponse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                    "Content-Type, X-Auth-Token, Authorization");
            corsResponse.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "X-Authorization-Url");
            corsResponse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");

            // If this is a CORS preflight request, we should break the filter chain to prevent the
            // XAuth filter from returning a HTTP 401.
            if (corsRequest.getMethod().equals("OPTIONS")) {
                corsResponse.getWriter().print("OK");
                corsResponse.getWriter().flush();
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {}
}
